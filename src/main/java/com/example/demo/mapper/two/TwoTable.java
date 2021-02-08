package com.example.demo.mapper.two;

import com.example.demo.mapper.ThreeTable;
import lombok.Data;

/**
 * @author haitao.li
 * @title: TwoTable
 * @description:
 * @date 2020/12/1610:00
 */
@Data
public class TwoTable {

    private String id;

    private String field;

    private ThreeTable table;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }



}
