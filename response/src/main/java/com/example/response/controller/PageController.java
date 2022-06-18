package com.example.response.controller;


import com.example.response.dto.User;
import org.apache.catalina.users.SparseUserDatabase;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {
    @RequestMapping("/main")
    public String main(){
        return "main.html";
    }
    // ResponseEntity

    @ResponseBody //request로 받겠다고 명시
    @GetMapping("/user")
    public User user(){
        var user = new User(); //타입 추론
        user.setName("steve");
        user.setAddress("패스트 캠퍼스");
        return user;
    }
}
