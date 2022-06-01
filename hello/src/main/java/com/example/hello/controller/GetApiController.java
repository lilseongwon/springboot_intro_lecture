package com.example.hello.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/get")
public class GetApiController {
    @GetMapping(path = "hello") //http://localhost:9090/api/get/hello -> 명시적으로 지정
    public String getHello(){
        return "get Hello";
    }
    @RequestMapping(path = "/hi", method = RequestMethod.GET) //모든 메소드 매핑 -> GET만 지정
    //http://localhost:9090/api/get/hi -> 이게 원래 방식이었지만 GETMapping으로 바뀜, 메소드 지정 필요 없음
    public String hi(){
        return "hi";
    }
    //http://localhost:9090/api/get/path-variable/{name} -> 가독성을 위해 소문자와 대시로만 주소 구성
    @GetMapping("/path-variable/{id}") //주소의 name과 변수 name은 같아야 함.
    //나중에 또 name이 나올경우 매칭이 안될수도 있음 -> 변수이름은 다르게 하되, pathvariable의 속성 맞춰주기
    public String pathVariable(@PathVariable(name = "id") String pathName){
        System.out.println("PathVariable: " +pathName);
        return pathName;
    }
}
