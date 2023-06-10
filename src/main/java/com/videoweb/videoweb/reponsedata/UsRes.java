package com.videoweb.videoweb.reponsedata;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
public class UsRes {
    private int videoId;
    private int userId;
    private String videoAddress;
    private String videoImage;
    private String videoTitle;
    private String videoBrief;
    private Date commentTime;
    private String videoTab;

}
