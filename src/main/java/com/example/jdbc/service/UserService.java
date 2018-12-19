package com.example.jdbc.service;

import com.example.jdbc.pojo.User;
import java.util.List;

public interface UserService {

     List<User> findUser();
     void deleteUser(int id);

}
