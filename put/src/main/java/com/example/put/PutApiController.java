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

    @PostMapping("/put")
    public void put(@RequestBody PostRequestDto requestDto){
        System.out.println(requestDto);
    }
}
