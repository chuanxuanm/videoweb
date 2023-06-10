package com.videoweb.videoweb.dao;

import com.videoweb.videoweb.model.Dynamic;
import com.videoweb.videoweb.model.Users;
import com.videoweb.videoweb.model.Videocomment;
import com.videoweb.videoweb.model.Videodata;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper
public interface InfoDao {
    @Autowired
    int getFans(Users users);
    @Autowired

    int getDynamic(Users users);

    @Autowired

    int getThumb(Users users);

    @Autowired
    List<Users> getFansList(Users users);

    @Autowired
    List<Dynamic> getDynamicList(Users users);

    @Autowired

    List<Videodata> getThumbLis(Users users);

    @Autowired
    List<Videodata> getVideoList(Users users);

    @Autowired
    List<Videodata> getTagVideoList(Videodata videodata);

    @Autowired
    List<Videodata> getRecomVideoList(Videodata videodata);

    @Autowired
    List<Videodata> getSearchVideoList (Videodata videodata);

    @Autowired
    List<Videocomment> selectComment(Videodata videodata);
    @Autowired
    List<Videodata> getHotVideoList(Users users);

}
