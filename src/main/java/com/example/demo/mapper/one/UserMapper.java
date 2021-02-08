package com.example.demo.mapper.one;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author haitao.li
 * @description:
 * @date 2021/2/7 15:36
 */
@Mapper
public interface UserMapper {


    void insert(@Param("user") User user);

    List<User> select();

}
