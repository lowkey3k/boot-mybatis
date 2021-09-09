package com.example.demo;

import com.example.demo.mapper.OneEnum;
import com.example.demo.mapper.ThreeTable;
import com.example.demo.mapper.one.OneTable;
import com.example.demo.mapper.one.OneTableCopy;
import com.example.demo.mapper.two.TwoTable;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author haitao.li
 * @description:
 * @date 2021/1/26 11:14
 */
public class BeanUtilTest {


    @Test
    public void test01() {
        OneTable table = new OneTable();
        table.setField("old field");
        table.setDate(new Date());
        table.setOneEnum(OneEnum.ONE);
        table.setLocalDateTime(LocalDateTime.now());
        Map<String, String> map = new HashMap<>();
        map.put("a", "s");
        table.setMap(map);
        table.setList(Lists.newArrayList("sss", "aaa"));
        TwoTable twoTable = new TwoTable();
        twoTable.setField("sdf");
        ThreeTable threeTable = new ThreeTable();
        threeTable.setDate(new Date());
        threeTable.setOneEnum(OneEnum.TWO);
        threeTable.setLocalDateTime(LocalDateTime.now());
        threeTable.setList(Lists.newArrayList("sdfsd"));
        twoTable.setTable(threeTable);

        table.setTwoTables(Lists.newArrayList(twoTable));
        table.setTable(twoTable);

        OneTableCopy target = new OneTableCopy();
        OneTableCopy target1 = new OneTableCopy();
        BeanUtils.copyProperties(table,target1);
        MapperFactory mapperFactory=new DefaultMapperFactory.Builder().build();
        mapperFactory.getMapperFacade().map(table,target);
        table.setField("new filed");
        twoTable.setField("new two field");
        System.out.println(target);
    }
}
