package com.example.jdbc.service.impl;

import com.example.jdbc.mapper.Usermapper;
import com.example.jdbc.pojo.User;
import com.example.jdbc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service(value = "userservice")
public class UserServiceImpl implements UserService {
    @Autowired
    private Usermapper user;
    @Override
    public List<User> findUser() {
        return user.findUser();
    }

    @Override
    public void deleteUser(int id) {
             user.deleteUser(id);
    }
}
