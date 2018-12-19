package com.example.jdbc.mapper;

import com.example.jdbc.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface Usermapper {
    @Select("select * from user")
    public List<User> findUser();

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into user(name,password,department) values(#{name},#{password},#{department})")
    public int insertUser(User user);
    @Delete("delete from user where id = #{id}")
    void deleteUser(int id);
    @Update("update user set name=#{name} ,password = #{password},department=#{department} where id = #{id}")
    void edituser(User user);

}
