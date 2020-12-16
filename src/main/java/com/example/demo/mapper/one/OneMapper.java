package com.example.demo.mapper.one;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author haitao.li
 * @title: OneMapper
 * @description:
 * @date 2020/12/1610:02
 */
@Repository
public interface OneMapper {

    void insert(@Param("oneTable") OneTable oneTable);

    List<OneTable> select();

}
