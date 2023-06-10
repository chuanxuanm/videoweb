package com.videoweb.videoweb.service;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.videoweb.videoweb.model.Users;
import com.videoweb.videoweb.model.Videodata;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.Date;
import java.util.List;
@Service
public class DownloadFile {
//    @Autowired
////    private OSSClient ossClient;
////    @Autowired
////    private OSSClient endpoint;
////    @Autowired
////    private OSSClient accessKeyId;
////    @Autowired
////    private OSSClient accessKeySecret;
//@Autowired
//private String bucketName;
@Value("${spring.oss.endpoint}")
private String endpoint;

    @Value("${spring.oss.access-key-id}")
    private String accessKeyId;

    @Value("${spring.oss.access-key-secret}")
    private String accessKeySecret;

    @Value("${spring.oss.bucket-name}")
    private String bucketName;


    public List<Videodata>  downLoadVideo(List<Videodata> Videodata){
        // 创建OSSClient实例
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        // 设置URL过期时间为1小时
        Date expiration = new Date(System.currentTimeMillis() + 3600 * 1000);
        URL url,url2,url3;
        // 生成URL
        for(int i=0;i<Videodata.size();i++){
            url = ossClient.generatePresignedUrl(bucketName, Videodata.get(i).getVideoAddress(), expiration);
            url2=ossClient.generatePresignedUrl(bucketName, Videodata.get(i).getVideoImage(), expiration);
            url3=ossClient.generatePresignedUrl(bucketName, Videodata.get(i).getHeadAddress(), expiration);
            Videodata.get(i).setVideoAddress(url.toString());
            Videodata.get(i).setVideoImage(url2.toString());
            Videodata.get(i).setHeadAddress(url3.toString());
        }


        // 关闭OSSClient实例
        ossClient.shutdown();
        return Videodata;
    }
    public Users downLoadHead(Users users){
        // 创建OSSClient实例
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);


        // 设置URL过期时间为1小时
        Date expiration = new Date(System.currentTimeMillis() + 3600 * 1000);
        URL url= ossClient.generatePresignedUrl(bucketName, users.getHeadAddress(), expiration);
        users.setHeadAddress(url.toString());


        // 关闭OSSClient实例
        ossClient.shutdown();
        return users;
    }


}
