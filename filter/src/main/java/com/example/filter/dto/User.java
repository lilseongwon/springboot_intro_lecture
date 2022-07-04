package com.example.filter.dto;

import lombok.*;

@Data //getter, setter, toString 전부 해줌
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String name;
    private int age;
}
