package com.videoweb.videoweb.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Users {
    private int userId;
    private String email="1";
    private String password;
    private String upName="默认用户";

    private String headAddress="default/QQ图片20230529213207.jpg";
    private String brief="这个人很懒，没有简介";
    private int fans;//粉丝个数
    private int page=1;
    private int offset=0;
    private int limit=12;
}
