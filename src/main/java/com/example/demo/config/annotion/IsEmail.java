package com.example.demo.config.annotion;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author haitao.li
 * @title: IsEmail
 * @description:
 * @date 2020/12/1614:12
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Constraint(validatedBy = IsEmailValidation.class)
public @interface IsEmail {

    String message() default "不是正确的email格式";

    boolean required() default true;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
