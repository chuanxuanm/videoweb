package com.videoweb.videoweb.reponsedata;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
public class SearchRes {
    private int page=1;
    private int offset=1;
    private int limit=12;
    private String videoAddress;
    private String videoImage;
    private String videoTitle;
    private String videoBrief;
    private Date commentTime;
    private int userId;
    private String upName;
    private String headAddress;
    private String brief;
    private Boolean thumb=false;

}
