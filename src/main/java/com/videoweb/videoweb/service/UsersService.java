package com.videoweb.videoweb.service;

import com.videoweb.videoweb.dao.UsersDao;
import com.videoweb.videoweb.model.Users;
import com.videoweb.videoweb.reponsedata.UsRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UsersService {
    @Autowired
    UsersDao usersDao;
    @Autowired
    TokenService tokenService;
    public String checkEmailExist(Users users){
        if(usersDao.checkEmailExist(users)>0){
            return "存在指定邮箱";
        }else{
            return "不存在指定邮箱";
        }
    }

    public String registerUser(Users users){
        if(usersDao.registerUser(users)>0){
            return "注册成功";
        }else{
            return "注册失败";
        }
    }

    public   Map<String,Object>  checkUserExist(Users users){
        Users getUsers=usersDao.checkUserExist(users);
        Map<String , Object>map=new HashMap<>();
        if(getUsers==null){
            map.put("登录失败","账户校验失败");
            return map;
        }
        int id=getUsers.getUserId();

        if(id!=0){

            map.put("登录信息","登录成功");
            map.put("token",tokenService.generateToken(getUsers.getUpName(),getUsers.getUserId()));
            return map;
        }else{
            return map;
        }
    }
    public UsRes getUserByLogin(Users user){
        return usersDao.getUserByLogin(user);
    }
    public String updateUserByToken(Users users){
        if(usersDao.updateUserByToken(users)>0){
            return "更新成功";
        }else{
            return "更新失败";
        }
    }





}
