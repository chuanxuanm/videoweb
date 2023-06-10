package com.videoweb.videoweb.service;

import com.aliyun.oss.OSSClient;
import com.videoweb.videoweb.model.GetFile;
import com.videoweb.videoweb.model.UsersFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
public class Upload {
    @Autowired
    private OSSClient ossClient;

    @Autowired
    private String bucketName;

    //上传视频和文件，储存文件名，返回GetFile用于储存到数据库
    public GetFile upLoadVideoe(GetFile getFile) {
        try (InputStream inputStream = getFile.getVideoFile().getInputStream()) {
            long fileSize = getFile.getVideoFile().getSize();
            System.out.println("视频文件大小：" + fileSize + "字节");
            String fileName = getFile.getVideoFile().getOriginalFilename();
            String uniqueFileName = System.currentTimeMillis() + "_" + fileName;
            String objectName = "uploads/video/" + uniqueFileName;
            ossClient.putObject(bucketName, objectName, inputStream);

            getFile.setVideoAddress(objectName);
            System.out.println(getFile.getVideoAddress());
        }catch (Exception e){
            System.out.println(e);
        }
        try (InputStream inputStream = getFile.getVideoImageFile().getInputStream()) {
            long fileSize = getFile.getVideoFile().getSize();
            System.out.println("视频封面文件大小：" + fileSize + "字节");
            String fileName = getFile.getVideoFile().getOriginalFilename();
            String uniqueFileName = System.currentTimeMillis() + "_" + fileName;
            String objectName = "uploads/videoImage/" + uniqueFileName;
            ossClient.putObject(bucketName, objectName, inputStream);

            getFile.setVideoImage(objectName);
            System.out.println(getFile.getVideoImage());
        }catch (Exception e){
            System.out.println(e);
        }
        return getFile;
    }

    public UsersFile upLoadHead(UsersFile usersFile )  {
        try (InputStream inputStream = usersFile.getUserImageFile().getInputStream()) {
            long fileSize = usersFile.getUserImageFile().getSize();
            System.out.println("视频文件大小：" + fileSize + "字节");
            String fileName = usersFile.getUserImageFile().getOriginalFilename();
            String uniqueFileName = System.currentTimeMillis() + "_" + fileName;
            String objectName = "uploads/video/" + uniqueFileName;
            ossClient.putObject(bucketName, objectName, inputStream);
            usersFile.setHeadAddress(objectName);
            System.out.println(objectName);
        }catch (Exception e){
            System.out.println(e);
        }
        return usersFile;

    }


}
