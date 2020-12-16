package com.example.demo.mapper.two;

import com.example.demo.mapper.one.OneTable;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author haitao.li
 * @title: TwoMapper
 * @description:
 * @date 2020/12/1610:03
 */
@Repository
public interface TwoMapper {

    void insert(@Param("twoTable") TwoTable twoTable);

    List<TwoTable> select();

}
