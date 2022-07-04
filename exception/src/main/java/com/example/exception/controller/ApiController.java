package com.example.exception.controller;

import com.example.exception.dto.User;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@RestController
@RequestMapping("/api/user")
@Validated
public class ApiController {

    @GetMapping("")
    public User get(
            @Size(min = 1)
            @RequestParam String name,

            @NotNull
            @RequestParam(required = false) Integer age){ //required = false는 필수가 아니라는 뜻.
        User user = new User();
        user.setName(name);
        user.setAge(age);

        int a = 10+age;

        System.out.println();

        return user;
    }

    @PostMapping("")
    public User post(@Valid @RequestBody User user){
        System.out.println(user);
        return user;
    }
}
