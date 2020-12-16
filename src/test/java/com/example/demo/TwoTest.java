package com.example.demo;

import com.example.demo.mapper.one.OneMapper;
import com.example.demo.mapper.one.OneTable;
import com.example.demo.mapper.two.TwoMapper;
import com.example.demo.mapper.two.TwoTable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author haitao.li
 * @title: OneTest
 * @description:
 * @date 2020/12/1610:22
 */
@SpringBootTest
public class TwoTest {
    @Autowired
    TwoMapper twoMapper;

    @Test
    public void test01(){
        TwoTable twoTable=new TwoTable();
        twoTable.setField("nihao");
        twoTable.setId("001");
        twoMapper.insert(twoTable);
    }


}
