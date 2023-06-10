package com.videoweb.videoweb;

import com.videoweb.videoweb.utils.WebSocketUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

@SpringBootApplication
@EnableScheduling
@EnableCaching
@EnableWebSocket
public class VideowebApplication {

    public static void main(String[] args) {
        SpringApplication.run(VideowebApplication.class, args);
    }



}
