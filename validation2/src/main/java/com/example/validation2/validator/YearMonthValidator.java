package com.example.validation2.validator;

import com.example.validation2.YearMonth;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class YearMonthValidator implements ConstraintValidator<YearMonth, String> {

    private String pattern; //확인할 값

    @Override
    public void initialize(YearMonth constraintAnnotation) {
        this.pattern = constraintAnnotation.pattern(); //초기화 시킬때는 어노테이션의 패턴 가져오기
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        //yyyyMM
        try {
            LocalDate localDate = LocalDate.parse(value+"01", DateTimeFormatter.ofPattern(this.pattern)); //어노테이션에 지정한 패탄(yyyyMMdd)
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
