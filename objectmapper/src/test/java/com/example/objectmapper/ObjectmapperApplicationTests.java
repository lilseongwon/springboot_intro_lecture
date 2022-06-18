package com.example.objectmapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ObjectmapperApplicationTests {

    @Test
    void contextLoads() throws JsonProcessingException {
        System.out.println("--------------");


        var objectMapper = new ObjectMapper();
        //object -> text
        //object mapper get method를 활용한다.

        var user = new User("steve", 10, "010-1111-2222");
        var text = objectMapper.writeValueAsString(user); //예외처리 필요
        System.out.println(text);

        //text -> object
        //object mapper는 default 생성자를 필요로 한다.
        var ObjectUser = objectMapper.readValue(text, User.class);
        System.out.println(ObjectUser);

        //기본 생성자가 있어야 한다.
    }

}
