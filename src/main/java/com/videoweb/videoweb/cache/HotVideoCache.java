package com.videoweb.videoweb.cache;

import com.videoweb.videoweb.model.Users;
import com.videoweb.videoweb.model.Videodata;
import com.videoweb.videoweb.service.InfoService;
import com.videoweb.videoweb.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HotVideoCache {

    @Autowired
    private Users users;
    @Autowired
    InfoService infoService;
    @Autowired
    RedisUtils redisUtils;

    @Scheduled(initialDelay = 0,fixedRate = 3600000)
    public void updateCache(){
        System.out.println("执行了");
        List<Videodata> vd=infoService.getHotVideoList(users);
        for(Videodata v:vd){
            redisUtils.saveVideo(v);
        }

    }

}
