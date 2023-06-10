package com.videoweb.videoweb.utils;

import com.alibaba.druid.util.StringUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.videoweb.videoweb.model.GetUser;
import com.videoweb.videoweb.model.Thumb;
import com.videoweb.videoweb.service.TokenService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.websocket.server.ServerEndpoint;
@Data
@Component
@ServerEndpoint("/websocket/{userId}")
public class WebSocketUtils {

    @Autowired
    private Thumb thumb;






    TokenService tokenService;
    private KafkaUtils kafkaUtils;
    private static CopyOnWriteArraySet<WebSocketUtils> webSockets =new CopyOnWriteArraySet<>();
    // 用来存在线连接用户信息
    private static ConcurrentHashMap<String,Session> sessionPool = new ConcurrentHashMap<String,Session>();
        private Session session;
        private String userId;







        @OnOpen
        public  void  onOpen(Session session) throws JsonProcessingException {
            thumb=new Thumb();
           // kafkaUtils.send("1","2","xiaoxi");

            tokenService=new TokenService();
            String info=session.getRequestURI().toString();

            String token=info.substring(info.indexOf("token=") + "token=".length());
            TokenService.TokenInfo tokenInfo=tokenService.parseToken(token);
            System.out.println("为空"+info);
           if(StringUtils.isEmpty(token))return;
            System.out.println("验证时"+this.userId);
           if(tokenService.isTokenExpired(tokenInfo))return;
            System.out.println("验证通过"+this.userId);
            this.userId=Integer.toString(tokenInfo.getUserId());
            this.session=session;
//            List<ProducerRecord<String ,String>>records=new ArrayList<>();
//            records.add(new ProducerRecord<>("login",Integer.toString(id),Integer.toString(id)));
//            kafkaProducer.send((ProducerRecord) records);
           // kafkaTemplate.send("login",Integer.toString(id),Integer.toString(id));
            webSockets.add(this);
            sessionPool.put(this.userId, session);
            ObjectMapper mapper=new ObjectMapper();
            kafkaUtils=new KafkaUtils();
           this.session.getAsyncRemote().sendText( mapper.writeValueAsString( kafkaUtils.getAll(this.userId)));
            System.out.println(mapper.writeValueAsString( kafkaUtils.getAll(this.userId)));
            System.out.println("最后"+this.userId);

        }

    @OnClose
    public void onClose() {
        try {
            webSockets.remove(this);
            sessionPool.remove(this.userId);
        } catch (Exception e) {
        }
    }

    //需要传递发送目标Id和发送消息
    @OnMessage
    public void onMessage(String Message) throws JsonProcessingException {
        System.out.println("inMe"+this.userId);

        ObjectMapper mapper=new ObjectMapper();
        GetUser getUser=mapper.readValue(Message,GetUser.class);
        Session session1=sessionPool.get(getUser.getUserId());
        String sendM=mapper.writeValueAsString(getUser);
        if (session1 != null&&session1.isOpen()) {
            try {
                System.out.println("send"+getUser.getUserId());
                session1.getAsyncRemote().sendText(sendM);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("store"+getUser.getUserId());
            kafkaUtils.send(getUser.getUserId(),this.userId,getUser.getReceiveMessage());
        }



    }


    public void sendOneMessage(String userId, String message) {
        Session session = sessionPool.get(userId);
        if (session != null&&session.isOpen()) {
            try {
                session.getAsyncRemote().sendText(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }




}
