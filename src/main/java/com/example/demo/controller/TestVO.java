package com.example.demo.controller;

import com.example.demo.config.annotion.IsEmail;
import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotEmpty;

/**
 * @author haitao.li
 * @title: TestVO
 * @description:
 * @date 2020/12/1614:09
 */
@Data
public class TestVO {

    @IsEmail
    private String email;
}
