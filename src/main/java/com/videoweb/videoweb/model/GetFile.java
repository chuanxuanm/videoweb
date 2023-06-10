package com.videoweb.videoweb.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Component
@Data
public class GetFile {
    private int videoId;
    private int userId;
    private String videoAddress;
    private String videoImage;
    private String videoTitle;
    private String videoBrief;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date commentTime;
    private String videoTab;
    private String audit;
    private MultipartFile videoFile;
    private MultipartFile videoImageFile;
    private int plays=0;
}
