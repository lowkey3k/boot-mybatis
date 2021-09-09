package com.example.demo.mapper.one;

import com.example.demo.mapper.OneEnum;
import com.example.demo.mapper.two.TwoTable;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author haitao.li
 * @title: OneTable
 * @description:
 * @date 2020/12/1610:00
 */
@Data
public class OneTable {

    private Long id;

    private String field;

    private Date date;

    private LocalDateTime localDateTime;

    private OneEnum oneEnum;

    private Map<String,String> map;

    private List<String> list;

    private List<TwoTable> twoTables;

    private TwoTable table;



}
