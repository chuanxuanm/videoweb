package com.videoweb.videoweb.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class SendInfo {
    private String sendId;
    private String message;
}
