package com.example.demo.mapper.one;

import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

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

    /**
     * rrowBounds 实现分页
     * @param rowBounds
     * @return
     */
    List<User> selectPage(RowBounds rowBounds);


    /**
     * Interceptor 实现分页，必须以ByInterceptor结构，自定义的Interceptor才能
     * 识别出来，并且必须传入PageInfo
     * @param pageInfo 自定义的分页
     * @return
     */
    List<User> selectPageByInterceptor(PageInfo pageInfo);


    /**
     * PageHelper
     */
    List<User> selectPageHelper();

}
