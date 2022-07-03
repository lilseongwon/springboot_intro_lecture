package com.example.exception.advice;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(value = Exception.class) //모든 오류를 다 받겠다. 오류범위 설정 가능
    public ResponseEntity exception(Exception e){ //설정한 예외를 매개변수로 받기
        System.out.println(e.getClass().getName()); //어떤 오류인지 알기 위해 예외클래스 가져오기
        System.out.println("----------------------");
        System.out.println(e.getLocalizedMessage());
        System.out.println("-------------------------");


        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity methodArgumentNotValidException(MethodArgumentNotValidException e){

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());

    }
}
