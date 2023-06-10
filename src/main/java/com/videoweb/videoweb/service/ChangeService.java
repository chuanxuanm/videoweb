package com.videoweb.videoweb.service;

import com.videoweb.videoweb.dao.ChangeInfo;
import com.videoweb.videoweb.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class ChangeService {
    @Autowired
    private ChangeInfo changeInfo;
    @Autowired
    private TokenService tokenService;
    @Autowired
    Upload upload;
    @Autowired
    DownloadFile downloadFile;

    public Users getUserInfoById(Users users,HttpServletRequest request){
        users.setUserId(tokenService.parseToken(request.getHeader("token")).getUserId());
        return downloadFile.downLoadHead(changeInfo.getUserInfoById(users));
    }
    public Users getUserInfoByIdT(Users users,HttpServletRequest request){
        return downloadFile.downLoadHead(changeInfo.getUserInfoById(users));
    }

    public String updateUserInfo(UsersFile usersFile, HttpServletRequest request ){
        usersFile.setUserId(tokenService.parseToken(request.getHeader("token")).getUserId());
        if(changeInfo.updateUserInfo(upload.upLoadHead(usersFile))>0){
            return "更新成功";
        }else {
            return "更新失败";
        }
    }

    public String insertDynamic(Dynamic dynamic,HttpServletRequest request){
        dynamic.setUserId(tokenService.parseToken(request.getHeader(("token"))).getUserId());
        if(changeInfo.insertDynamic(dynamic)>0){
            return "添加动态成功";
        }else {
            return "添加动态失败";
        }
    }

    public String deleteDynamic(Dynamic dynamic,HttpServletRequest request){
        dynamic.setUserId(tokenService.parseToken(request.getHeader("token")).getUserId());
        if(changeInfo.deleteDynamic(dynamic)>0){
            return "删除动态成功";
        }else {
            return "删除动态失败";
        }
    }

    public String insertVideodata(GetFile getFile,HttpServletRequest request){
        getFile.setUserId(tokenService.parseToken(request.getHeader("token")).getUserId());
        if(changeInfo.insertVideodata(upload.upLoadVideoe(getFile))>0){
            return "投稿视频成功";
        }else {
            return "投稿视频失败";
        }
    }

    public String insertComment(Videocomment videocomment,HttpServletRequest request){
        videocomment.setUserId(tokenService.parseToken(request.getHeader("token")).getUserId());
        if(changeInfo.insertComment(videocomment)>0){
            return "添加评论成功";
        }else {
            return "添加评论失败";
        }
    }


    public String insertThumb(Thumb thumb,HttpServletRequest request){
        thumb.setUserId(tokenService.parseToken(request.getHeader("token")).getUserId());
        if(changeInfo.insertThumb(thumb)>0){
            return "点赞成功";
        }else {
            return "点赞失败";
        }

    }
    public Boolean checkThumb(Thumb thumb,HttpServletRequest request){
        thumb.setUserId(tokenService.parseToken(request.getHeader("token")).getUserId());
        if(changeInfo.checkThumb(thumb)>0){
            return true;
        }else {
            return false;
        }
    }
    public String updatePlays(Videodata videodata,HttpServletRequest request){
        videodata.setUserId(tokenService.parseToken(request.getHeader("token")).getUserId());
        if(changeInfo.updatePlays(videodata)>0){
            return "添加成功";
        }else {
            return "添加失败";
        }
    }
}
