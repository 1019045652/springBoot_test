package com.example.jdbc.Controller;

import com.example.jdbc.mapper.Imgmapper;
import com.example.jdbc.mapper.Usermapper;
import com.example.jdbc.pojo.Imgs;
import com.example.jdbc.pojo.Result;
import com.example.jdbc.pojo.User;
import com.example.jdbc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    Usermapper usermapper;
    @Autowired
    UserService userService;
    @Autowired
    Imgmapper imgmapper;
//    查询用户
    @GetMapping(value = "/showuser")
    public Result showuser(Model model){
        List<User> userList = usermapper.findUser();
        model.addAttribute("userlist",userList);
        Result result = new Result(true,200,"查询成功",userList);
        return result;
    }
//   添加用户
    @PostMapping(value = "/emp")
    @ResponseBody
    public User insertUser( @RequestBody User user){
        System.out.println(user.getName());
        usermapper.insertUser(user);
        return user;
    }
//删除用户
    @PostMapping(value = "/deleteUser")
        public Result deleteUser(@RequestBody User user){
        System.out.println(user.getId());
        usermapper.deleteUser(user.getId());
        List<User> userList = usermapper.findUser();
        Result result = new Result(true,200,"成功啦！",userList);
        return result;
    }
    //修改用户
    @PostMapping("/edituser")
    public Result edituser(@RequestBody User user){
        usermapper.edituser(user);
        Result result = new Result(true,200,"修改成功！",user);
        return result;
    }

    //文件上传
    @PostMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        if (file.isEmpty()) {
            return "上传失败，请选择文件";
        }

        System.out.println(request.getRequestURL());
        String fileName = file.getOriginalFilename();
        String filePath = "E:\\projectDATA\\img\\";
        String path = ClassUtils.getDefaultClassLoader().getResource("").getPath()+"static/";
        Imgs img = new Imgs();
        img.setUrl("http://localhost:8081/"+fileName);
        imgmapper.addImg(img);
        File dest = new File(filePath + fileName);
        try {
            file.transferTo(dest);
            return "上传成功啦！！";
        } catch (IOException e) {

        }
        return "上传失败！";
    }
    @GetMapping("/showimg")
    public Result showimg(){
         List<Imgs> imgsList = imgmapper.findImgs();
         Result result = new Result(true,200,"成功了！",imgsList);
         return result;
    }
}
