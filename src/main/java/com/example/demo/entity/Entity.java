package com.example.demo.entity;

import java.io.Serializable;

 /**
 　　* @description:
 　　* @author haitao.li
 　　* @date 2021/1/26 14:26
 　　*/
public interface Entity<PK> extends Serializable {

    String ID = "id";

    PK getId();

    void setId(PK id);
}
