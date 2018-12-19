package com.example.jdbc.mapper;

import com.example.jdbc.pojo.Imgs;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Imgmapper {

    @Insert("insert into imgs(url) values(#{url}) ")
    void addImg(Imgs imgs);
    @Select("select * from imgs")
    List<Imgs> findImgs();
}
