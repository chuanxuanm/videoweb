package com.videoweb.videoweb.controller;

import com.videoweb.videoweb.model.Users;
import com.videoweb.videoweb.reponsedata.UsRes;
import com.videoweb.videoweb.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    UsersService usersService;
    @PostMapping("/registerUser")
    public String registerUser(@RequestBody Users users){

        return usersService.registerUser(users);
    }
    @PostMapping("/checkUserExist")
    public Map<String , Object> checkUserExist(@RequestBody Users users){
        return usersService.checkUserExist(users);
    }
    @PostMapping("/getUserByLogin")
    public UsRes getUserByLogin(@RequestBody Users user){
        return usersService.getUserByLogin(user);
    }
    @PostMapping("/updateUserByToken")
    public String updateUserByToken(@RequestBody Users users){
        return usersService.updateUserByToken(users);
    }
}
