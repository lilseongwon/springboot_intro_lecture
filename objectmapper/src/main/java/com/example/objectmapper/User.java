package com.example.objectmapper;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonValueInstantiator;

public class User {
    private String name;
    private int age;

    @JsonProperty("phone_number")
    private String phoneNumber;

    public User(){ //기본 생성자
        this.name = null;
        this.age = 0;
        this.phoneNumber = null;
    }


    public User(String name, int age, String phoneNumber){
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }
    //object mapper가 참조하기 위해 getter 붙임.
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    /*public User getDefaultUser(){
        return new User("default", 0);
    } 클래스가 object mapper에 활용될 때는 절대 get을 붙이면 안된다! */

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
