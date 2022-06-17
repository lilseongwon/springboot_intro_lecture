package com.example.put.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarDto {
    private String name;
    private String carNumber;

    @Override
    public String toString() {
        return "CarDto{" +
                "name='" + name + '\'' +
                ", carNumber='" + carNumber + '\'' +
                '}';
    }
}
