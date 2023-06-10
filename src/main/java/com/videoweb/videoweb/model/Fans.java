package com.videoweb.videoweb.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Fans {
    private int id;
    private int follower_id;
    private int followedId;

}
