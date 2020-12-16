package com.example.demo.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author haitao.li
 * @title: DataSourceConfig
 * @description:
 * @date 2020/12/169:45
 */
@Configuration
public class DataSourceConfig {

    @Bean(name = "oneDataSource")
    @ConfigurationProperties(prefix = "mybatis.one")
    public DruidDataSource one() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "twoDataSource")
    @ConfigurationProperties(prefix = "mybatis.two")
    public DruidDataSource two() {
        return DruidDataSourceBuilder.create().build();
    }
}
