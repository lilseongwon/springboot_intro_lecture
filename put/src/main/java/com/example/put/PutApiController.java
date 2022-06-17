package com.example.put;

import com.example.put.dto.PostRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PutApiController {

    @PostMapping("/put/{userId}")
    public PutRequestDto put(@RequestBody PutRequestDto requestDto, @PathVariable(name = "userId") Long id){
        System.out.println(requestDto);
        return requestDto; //리턴 타입을 dto로 바꾸고 dto그대로 반환하면 받은값 그대로 주니까 JSON값으로 리턴
    }
}
