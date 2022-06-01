package com.example.hello.controller;

import com.example.hello.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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

//search?q=intellij
// &oq=intell
// &aqs=chrome.1.69i57j69i59j0i512j0i433i512j
// &sourceid=chrome
// &ie=UTF-8
//쿼리 파라미터 -> 검색할때 매개변수, key = value값


    //http://localhost:9090/api/get/query-param?user=steve&email=steve@gmail.com
    @GetMapping(path = "query-param")
    public String queryParam(@RequestParam Map<String, String> queryParam) {

        StringBuilder sb = new StringBuilder();

        queryParam.entrySet().forEach(entry -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("\n");

            sb.append(entry.getKey()+" = "+entry.getValue()+"\n");
        });
        return sb.toString();
    }
    @GetMapping("query-param02")
    public String queryparam02(
        @RequestParam String name, //변수를 명시적으로 설정 할때는 @RequestParam 붙이면 됨 -> 계속 이러기 힘드니까 Dto만듦.
        @RequestParam String email,
        @RequestParam int age
        ){
        System.out.println(name);
        System.out.println(email);
        System.out.println(age);

    return name+" "+email+" "+age;
    }

    @GetMapping("query-param03")
    public String queryparam03(UserRequest userRequest){ //여기서는 스프링부트가 dto랑 매치시켜서 Request Param을 쓸 필요가 없음
        System.out.println(userRequest.getName());
        System.out.println(userRequest.getAge());
        System.out.println(userRequest.getEmail());

        return userRequest.toString();
    }
}
