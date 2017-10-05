package com.dreaouth.service;

import com.dreaouth.dao.UserMapper;
import com.dreaouth.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {
    @Autowired
    private UserMapper userMapper;

    public int checktUsers(User user){
        List<User> list=userMapper.selectAll();
        for(User u:list){
            if (u.getName().equals(user.getName())){
                if (u.getPassword().equals(user.getPassword())){
                    return 1;
                }
                return  -1;
            }
        }
        return -2;
    }
    public User getUser(String username){
        User u=userMapper.selectByUsername(username);
        return u;
    }
    public boolean register(User user){
        List<User> list=userMapper.selectAll();
        for(User u:list){
            if (u.getName().equals(user.getName())){
                return false;
            }
        }
        userMapper.insert(user);
        return true;
    }


}
