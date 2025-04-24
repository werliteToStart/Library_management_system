package com.example.service;

import com.example.bean.Role;
import com.example.bean.User;
import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    public User queryUserByUsername(String username){
        return userMapper.queryUserByUsername(username);
    }
    public User queryUserById(int id){
        return userMapper.queryUserById(id);
    }
    public List<User> queryAllUser(){
        return userMapper.queryAllUser();
    }

    public Role queryRoleById(int id){
        return userMapper.queryRoleById(id);
    }

    public int updateUser(User user){
        return userMapper.updateUser(user);
    }
    public int updateUserById(User user){
        return userMapper.updateUserById(user);
    }
}
