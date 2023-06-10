package com.videoweb.videoweb.dao;

import com.videoweb.videoweb.model.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper
public interface ChangeInfo {
    @Autowired
    Users getUserInfoById(Users users);
    @Autowired
    int updateUserInfo(UsersFile usersFile);
    @Autowired
    int insertDynamic(Dynamic dynamic);
    @Autowired
    int deleteDynamic(Dynamic dynamic);
    @Autowired
    int insertVideodata(GetFile getFile);
    @Autowired
    int insertComment(Videocomment videocomment);
    @Autowired
    int insertThumb(Thumb thumb);
    @Autowired
    int checkThumb(Thumb thumb);
    @Autowired
    int updatePlays(Videodata videodata);

}
