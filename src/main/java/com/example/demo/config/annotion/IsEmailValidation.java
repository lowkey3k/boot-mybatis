package com.example.demo.config.annotion;

import org.springframework.stereotype.Component;
import org.springframework.util.PatternMatchUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * @author haitao.li
 * @title: IsEmailValidation
 * @description:
 * @date 2020/12/1614:25
 */
@Component
public class IsEmailValidation implements ConstraintValidator<IsEmail, String> {

    private Boolean isValidation;


    @Override
    public void initialize(IsEmail isEmail) {
        this.isValidation = isEmail.required();
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        if (isValidation) {
            System.out.println(">>>>>>>>>>>>>>>>>>>>");
            boolean matches = Pattern.matches("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$", email);
            if (matches) {
                return true;
            }
        }
        return false;
    }
}
