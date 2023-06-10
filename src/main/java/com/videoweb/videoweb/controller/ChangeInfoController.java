package com.videoweb.videoweb.controller;

import com.videoweb.videoweb.model.*;
import com.videoweb.videoweb.service.ChangeService;
import com.videoweb.videoweb.service.DownloadFile;
import com.videoweb.videoweb.service.Upload;
import com.videoweb.videoweb.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@RequestMapping("/ChangeInfo")
public class ChangeInfoController {
    @Autowired
    private ChangeService changeService;
    @Autowired
    Upload upload;
    @Autowired
    RedisUtils redisUtils;
    @Autowired
    DownloadFile downloadFile;
    @PostMapping("/Test")
    public Users Test(@ModelAttribute Users users, HttpServletRequest request){
        System.out.println("123");
        users.setHeadAddress("default/QQ图片20230529213207.jpg");
        Users u= downloadFile.downLoadHead(users);
        System.out.println(u.getHeadAddress());
        return u;
    }




    @PostMapping("/getUserInfoById")
    public Users getUserInfoById(@ModelAttribute Users users, HttpServletRequest request){
        return changeService.getUserInfoById(users,request);
    }
    @PostMapping("/getUserInfoByIdT")
    public Users getUserInfoByIdT(@RequestBody Users users, HttpServletRequest request){
        return changeService.getUserInfoByIdT(users,request);
    }

    @PostMapping("/updateUserInfo")
    public String updateUserInfo(@ModelAttribute UsersFile usersFile, HttpServletRequest request){
        return changeService.updateUserInfo(usersFile,request);
    }

    @PostMapping("/insertDynamic")
    public String insertDynamic(@RequestBody Dynamic dynamic,HttpServletRequest request){
        return changeService.insertDynamic(dynamic,request);
    }

    @PostMapping("/deleteDynamic")
    public String deleteDynamic(@RequestBody Dynamic dynamic,HttpServletRequest request){
        return changeService.deleteDynamic(dynamic,request);
    }

    @PostMapping("/insertVideodata")
    public String insertVideodata(@ModelAttribute GetFile getFile,HttpServletRequest request) throws IOException {
        return changeService.insertVideodata(upload.upLoadVideoe(getFile), request);
    }
    @PostMapping("/insertComment")
    public String insertVideodata(@RequestBody Videocomment videocomment,HttpServletRequest request) throws IOException {


        return changeService.insertComment(videocomment,request);
    }
    @PostMapping("/insertThumb")
    public String insertThumb(@RequestBody Thumb thumb,HttpServletRequest request){
        return changeService.insertThumb(thumb,request);
    }
    @PostMapping("/checkThumb")
    public Boolean checkThumb(@RequestBody Thumb thumb,HttpServletRequest request){
        return changeService.checkThumb(thumb,request);
    }
    @PostMapping("/updatePlays")
    public String updatePlays(@RequestBody Videodata videodata,HttpServletRequest request){
        redisUtils.increasePlays(Integer.toString(videodata.getVideoId()));
        return changeService.updatePlays(videodata,request);
    }
}
