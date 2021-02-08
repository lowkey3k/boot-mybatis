package com.example.demo.entity;

/**
 * @author haitao.li
 * @description:
 * @date 2021/1/26 14:24
 */
public abstract class BaseCrudEntity<PK> implements Entity<PK> {

    /**
     * 状态码，0无效，1有效
     */
    private Integer status;

}
