package com.example.put.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class) //JsonProperty와 다르게 클래스 전부에 매핑해준다
public class PostRequestDto {
    private String name;
    private int age;
    private List<CarDto> carList;

    @Override
    public String toString() {
        return "PostRequestDto{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", carList=" + carList +
                '}';
    }
}
