package com.example.demo.mapper;

import lombok.Data;
import lombok.Getter;

/**
 * @author haitao.li
 * @description:
 * @date 2021/1/26 11:18
 */
@Getter
public enum OneEnum {

    ONE(1), TWO(2);

    private final Integer type;

    private OneEnum(Integer type) {
        this.type = type;
    }
}
