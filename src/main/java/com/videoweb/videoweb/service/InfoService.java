package com.videoweb.videoweb.service;

import com.videoweb.videoweb.dao.InfoDao;
import com.videoweb.videoweb.model.Dynamic;
import com.videoweb.videoweb.model.Users;
import com.videoweb.videoweb.model.Videocomment;
import com.videoweb.videoweb.model.Videodata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class InfoService {
    @Autowired
    private InfoDao infoDao;
    @Autowired
    TokenService tokenService;
    @Autowired
    DownloadFile downloadFile;

    public int getFans(Users users, HttpServletRequest request){
        return infoDao.getFans(users);
    }

    public int getDynamic(Users users,HttpServletRequest request){
        users.setUserId(tokenService.parseToken(request.getHeader("token")).getUserId());
        return infoDao.getDynamic(users);
    }

    public int getThumb(Users users,HttpServletRequest request){
        users.setUserId(tokenService.parseToken(request.getHeader("token")).getUserId());
        return infoDao.getThumb(users);
    }

    public List<Users> getFansList(Users users,HttpServletRequest request){
        users.setUserId(tokenService.parseToken(request.getHeader("token")).getUserId());
        users.setOffset(users.getLimit()*(users.getPage()-1));
        return infoDao.getFansList(users);
    }

    public List<Dynamic> getDynamicList(Users users,HttpServletRequest request){
        users.setUserId(tokenService.parseToken(request.getHeader("token")).getUserId());
        users.setOffset(users.getLimit()*(users.getPage()-1));
        return infoDao.getDynamicList(users);
    }

    public List<Videodata> getThumbLis(Users users,HttpServletRequest request){
        users.setUserId(tokenService.parseToken(request.getHeader("token")).getUserId());
        users.setOffset(users.getLimit()*(users.getPage()-1));
        return downloadFile.downLoadVideo(infoDao.getThumbLis(users));
    }

    public List<Videodata> getVideoList(Users users,HttpServletRequest request){
        users.setUserId(tokenService.parseToken(request.getHeader("token")).getUserId());
        users.setOffset(users.getLimit()*(users.getPage()-1));
        System.out.println(users.getUserId()+","+users.getLimit()+","+users.getOffset()+","+(users.getPage()-1));
        return downloadFile.downLoadVideo(infoDao.getVideoList(users));
    }

    public List<Videodata> getTagVideoList(Videodata videodata,HttpServletRequest request){
        videodata.setUserId(tokenService.parseToken(request.getHeader("token")).getUserId());
        videodata.setOffset(videodata.getLimit()*(videodata.getPage()-1));

        return downloadFile.downLoadVideo(infoDao.getTagVideoList(videodata));
    }

    public List<Videodata> getRecomVideoList(Videodata videodata,HttpServletRequest request){
        videodata.setUserId(tokenService.parseToken(request.getHeader("token")).getUserId());
        videodata.setOffset(videodata.getLimit()*(videodata.getPage()-1));
        return downloadFile.downLoadVideo(infoDao.getRecomVideoList(videodata));
    }

    public List<Videodata> getSearchVideoList(Videodata videodata,HttpServletRequest request){
        videodata.setUserId(tokenService.parseToken(request.getHeader("token")).getUserId());
        videodata.setOffset(videodata.getLimit()*(videodata.getPage()-1));
                return downloadFile.downLoadVideo(infoDao.getSearchVideoList(videodata));
    }
    public List<Videocomment> selectComment(Videodata videodata,HttpServletRequest request){
        videodata.setUserId(tokenService.parseToken(request.getHeader("token")).getUserId());
        videodata.setOffset(videodata.getLimit()*(videodata.getPage()-1));
        return infoDao.selectComment(videodata);
    }
    public  List<Videodata> getHotVideoList(Users users){
        return infoDao.getHotVideoList(users);
    }



}
