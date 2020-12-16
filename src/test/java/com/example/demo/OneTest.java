package com.example.demo;

import com.example.demo.mapper.one.OneMapper;
import com.example.demo.mapper.one.OneTable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Random;

/**
 * @author haitao.li
 * @title: OneTest
 * @description:
 * @date 2020/12/1610:22
 */
@SpringBootTest
public class OneTest {
    @Autowired
    OneMapper oneMapper;

    @Test
    public void test01(){
        OneTable oneTable=new OneTable();
        oneTable.setField("nihao");
        oneTable.setId(Math.random()+"");
        oneMapper.insert(oneTable);
        List<OneTable> select = oneMapper.select();
        Assert.notEmpty(select,"not empty");
    }


}
