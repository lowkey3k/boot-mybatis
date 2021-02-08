package com.example.demo.mapper;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @author haitao.li
 * @description:
 * @date 2021/1/26 11:20
 */
@Data
public class ThreeTable {

    private String id;

    private String field;

    private Date date;

    private LocalDateTime localDateTime;

    private OneEnum oneEnum;

    private List<String> list;
}
