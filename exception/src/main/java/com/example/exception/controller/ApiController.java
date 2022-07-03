package com.example.exception.controller;

import com.example.exception.dto.User;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class ApiController {

    @GetMapping("")
    public User get(@RequestParam String name, @RequestParam(required = false) Integer age){ //required = false는 필수가 아니라는 뜻.
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

    @ExceptionHandler(value = MethodArgumentNotValidException.class) //Global보다 컨트롤러에서 지정한 핸들러의 우선순위가 높다.
    public ResponseEntity methodArgumentNotValidException(MethodArgumentNotValidException e){
        System.out.println("ApiController");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());

    }
}
