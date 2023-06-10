package com.videoweb.videoweb.dao;

import com.videoweb.videoweb.model.Users;
import com.videoweb.videoweb.reponsedata.UsRes;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper
public interface UsersDao {
    /**
     * 查询是否存在指定的邮箱地址
     */
    @Autowired
    int checkEmailExist(Users user);

    /**
     * 向 users 表中插入一条新的记录
     */
    @Autowired
    int registerUser(Users user);

    /**
     * 查询是否存在这个账号密码的用户
     */
    @Autowired
    Users  checkUserExist(Users users);

    /**
     * 根据用户Id查询用户信息
     */
    @Autowired
    UsRes getUserByLogin(Users user);

    /**
     * 根据用户id更新用户信息
     */
    @Autowired
    int updateUserByToken(Users user);

}
