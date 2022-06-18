package com.example.response.controller;

import com.example.response.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {

    //TEXT
    @GetMapping("/text")
    public String text(@RequestParam String account){
        return account;
    }

    //JSON
    // req -> object mapper -> object -> method -> object -> object mapper -> json -> response
    @PostMapping("/json")
    public User json(@RequestBody User user){
        return user;
    }
    //ResponseEntity
    @PutMapping
    public ResponseEntity<User> put(@RequestBody User user){ //http status를 정해주기 위해 response entity 객체 사용
        return ResponseEntity.status(HttpStatus.CREATED).body(user); //201번 -> 리소스 생성시 201, 수정시 202, 바디값에 user.
    }
}
