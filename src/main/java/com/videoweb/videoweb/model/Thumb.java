package com.videoweb.videoweb.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Thumb {
    private int id;
    private int userId;
    private int videoId;
}
