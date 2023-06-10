package com.videoweb.videoweb.config;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OSSConfig {
    @Value("${spring.oss.endpoint}")
    private String endpoint;

    @Value("${spring.oss.access-key-id}")
    private String accessKeyId;

    @Value("${spring.oss.access-key-secret}")
    private String accessKeySecret;

    @Value("${spring.oss.bucket-name}")
    private String bucketName;

    @Bean
    public OSSClient ossClient() {
        return (OSSClient) new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
    }

    @Bean
    public String bucketName() {
        return bucketName;
    }
}
