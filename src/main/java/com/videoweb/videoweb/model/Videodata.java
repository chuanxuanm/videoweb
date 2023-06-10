package com.videoweb.videoweb.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
@Data
public class Videodata {
    private int videoId;
    private int userId;
    private String upName;
    private String headAddress;
    private String videoAddress;
    private String videoImage;
    private String videoTitle;
    private String videoBrief;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date commentTime;
    private int plays=0;
    private String videoTab;
    private int audit=0;
    private int page=1;
    private int offset=1;
    private int limit=12;
    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("videoId", videoId);
        map.put("userId", userId);
        map.put("upName", upName);
        map.put("headAddress", headAddress);
        map.put("videoAddress", videoAddress);
        map.put("videoImage", videoImage);
        map.put("videoTitle", videoTitle);
        map.put("videoBrief", videoBrief);
        map.put("commentTime", commentTime);
        map.put("plays", plays);
        map.put("videoTab", videoTab);
        return map;
    }
    public void fromMap(Map<Object, Object> map) {
        videoId = (int) map.get("videoId");
        userId = (int)map.get("userId");
        upName = (String) map.get("upName");
        headAddress = (String) map.get("headAddress");
        videoAddress = (String) map.get("videoAddress");
        videoImage = (String) map.get("videoImage");
        videoTitle = (String) map.get("videoTitle");
        videoBrief = (String) map.get("videoBrief");
        commentTime = (Date) map.get("commentTime");
        plays = (int) map.get("plays");
        videoTab = (String) map.get("videoTab");
    }
}
