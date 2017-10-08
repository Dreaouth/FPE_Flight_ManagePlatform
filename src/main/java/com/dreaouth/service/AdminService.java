package com.dreaouth.service;

import com.dreaouth.dao.UserMapper;
import com.dreaouth.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private UserMapper userMapper;

    public List<User> getList() {
        return userMapper.selectAll();
    }

    public User select(String username) {
        User user = userMapper.selectByUsername(username);
        return user;
    }

    public boolean insertUser(User user) {
        List<User> list = userMapper.selectAll();
        for (User u : list) {
            if (u.getName().equals(user.getName())) {
                return false;
            }
        }
        userMapper.insert(user);
        return true;
    }

    public void delete(String id){
        userMapper.deleteByPrimaryKey(Integer.parseInt(id));
    }

    public boolean update(User user){
        try{
            userMapper.updateByPrimaryKey(user);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}

