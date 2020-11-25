package com.kuang.controller;

import com.kuang.mapper.UserMapper;
import com.kuang.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @RequestMapping({"/","/index"})
    public String toindex(Model model){
        model.addAttribute("msg","欢迎光临陈庆龙的电商平台");
        return "index";

    }
    @Autowired
    UserMapper userMapper;
    @RequestMapping("/regist")
    public String regist(String username,String password){
        if(username!=null&&password!=null){
            User user=new User(username,password);
            userMapper.addUser(user);
        }
        return "regist";
    }
    @RequestMapping("/user/update")
    public String update(){
        return "user/update";
    }
    @RequestMapping("/user/add")
    public String add(){
        return "user/add";
    }
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }
    @RequestMapping("/login")
    public String login(String username,String password,Model model){
        Subject subject= SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);

        try{
            subject.login(token);
            return "emp/list";
        }catch(UnknownAccountException e){
            model.addAttribute("msg","Wrong userName");
            return "login";
        }


    }
}
