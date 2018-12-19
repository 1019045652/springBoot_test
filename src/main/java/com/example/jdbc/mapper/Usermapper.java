package com.example.jdbc.mapper;

import com.example.jdbc.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface Usermapper {
    //查询所有用户
    @Select("select * from user")
    List<User> findUser();
    //插入用户
    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into user(name,password,department) values(#{name},#{password},#{department})")
    int insertUser(User user);
    //根据id删除用户
    @Delete("delete from user where id = #{id}")
    void deleteUser(int id);
    //更新用户
    @Update("update user set name=#{name} ,password = #{password},department=#{department} where id = #{id}")
    void edituser(User user);
}
