package com.example.demo.dto;

import lombok.Data;

/**
 * @author haitao.li
 * @title: QueryParam
 * @description: 查询条件
 * @date 2020/12/18 15:57
 */
@Data
public class PageQueryDTO {

    /**
     * 起始页
     */
    private Integer pageNum=1;

    /**
     * 页面数据大小
     */
    private Integer pageSize=10;

}
