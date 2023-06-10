package com.videoweb.videoweb.model;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
@Data
public class UsersFile {
    private int userId;
    private String email;
    private String password;
    private String upName;
    private String headAddress;
    private String brief;
    private int page=1;
    private int offset=1;
    private int limit=12;
    private MultipartFile userImageFile;
}
