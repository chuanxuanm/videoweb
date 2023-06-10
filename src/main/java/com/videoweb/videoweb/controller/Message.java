package com.videoweb.videoweb.controller;

import com.videoweb.videoweb.utils.KafkaUtils;
import com.videoweb.videoweb.utils.WebSocketUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class Message {
    @Resource
    private WebSocketUtils webSocketUtils;

    @Autowired
    KafkaUtils kafkaUtils;
    @MessageMapping("/hello")
    public void getMess( ) {


    }

}
