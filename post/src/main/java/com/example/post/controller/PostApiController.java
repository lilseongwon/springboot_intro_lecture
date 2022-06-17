package com.example.post.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class PostApiController {

    @PostMapping("/post")
    public void post(@RequestBody Map<String, Object> requestData){ //object = 모두가능
        requestData.forEach((key, value) -> { //key, value 각각출력 
            System.out.println("key : " + key);
            System.out.println("value: " + value);
        });
    }

}
