package com.videoweb.videoweb.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Admin {
    private int id;
    private String account;
    private String password;
}
