package com.videoweb.videoweb.controller;

import com.videoweb.videoweb.model.Dynamic;
import com.videoweb.videoweb.model.Users;
import com.videoweb.videoweb.model.Videocomment;
import com.videoweb.videoweb.model.Videodata;
import com.videoweb.videoweb.service.InfoService;
import com.videoweb.videoweb.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/Info")
public class InfoController {
    @Autowired
    private InfoService infoService;
    @Autowired
    private RedisUtils redisUtils;

    @PostMapping("/getFans")
    public int getFans(@RequestBody Users users,HttpServletRequest request){
        return infoService.getFans(users,request);
    }

    @PostMapping("/getDynamic")
    public int getDynamic(@RequestBody Users users,HttpServletRequest request){
        return infoService.getDynamic(users,request);
    }

    @PostMapping("/getThumb")
    public int getThumb(@RequestBody Users users,HttpServletRequest request){
        return infoService.getThumb(users,request);
    }

    @PostMapping("/getFansList")
    public List<Users> getFansList(@RequestBody Users users,HttpServletRequest request){
        return infoService.getFansList(users,request);
    }

    @PostMapping("/getDynamicList")
    public List<Dynamic> getDynamicList(@RequestBody Users users,HttpServletRequest request){
        return infoService.getDynamicList(users,request);
    }

    @PostMapping("/getThumbList")
    public List<Videodata> getThumbList(@RequestBody Users users,HttpServletRequest request){
        return infoService.getThumbLis(users,request);
    }

    //每小时更新一次
    @PostMapping("/getHotVideoList")
    public List<Videodata> getHotVideoList(@RequestBody Users users,HttpServletRequest request){
        System.out.println("hotVideo");
        return redisUtils.getPopularVideos();
    }
    @PostMapping("/getVideoList")
    public List<Videodata> getVideoList(@RequestBody Users users,HttpServletRequest request){
        return infoService.getVideoList(users,request);
    }

    @PostMapping("/getTagVideoList")
    public List<Videodata> getTagVideoList(@RequestBody Videodata videodata,HttpServletRequest request){
        return infoService.getTagVideoList(videodata,request);
    }

    @PostMapping("/getRecomVideoList")
    public List<Videodata> getRecomVideoList(@RequestBody Videodata videodata,HttpServletRequest request){
        return infoService.getRecomVideoList(videodata,request);
    }

    @PostMapping("/getSearchVideoList")
    public List<Videodata> getSearchVideoList(@RequestBody Videodata videodata,HttpServletRequest request){
        return infoService.getSearchVideoList(videodata,request);
    }
    @PostMapping("/selectComment")
    public List<Videocomment> selectComment(@RequestBody Videodata videodata,HttpServletRequest request){
        return infoService.selectComment(videodata,request);
    }
}
