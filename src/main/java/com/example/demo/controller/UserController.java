package com.example.demo.controller;

import com.example.demo.error.BusinessException;
import com.example.demo.po.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 描述:用户控制层
 * @author 王玉
 * @date 2019/3/3
 */
@Controller
@RequestMapping("/User")
public class UserController {
    @Autowired
    private UserService userService ;

    /**
     * thymeleaf测试
     * @return
     */
    @RequestMapping("/test")
    public String test(Model model){
        List<User> userList = userService.findAll() ;
        model.addAttribute("users",userList) ;
        return "User" ;
    }

    @RequestMapping("/findAll")
    public String findAll(Model model){
        List<User> userList = userService.findAll() ;
        model.addAttribute("users",userList) ;
        throw new BusinessException("业务异常") ;

    }

    @RequestMapping("/testRetry")
    public  String testRetry() {
        User user =
                userService.findByNameAndPasswordRetry("唐伯虎","秋香") ;
        return "success" ;
    }

}
