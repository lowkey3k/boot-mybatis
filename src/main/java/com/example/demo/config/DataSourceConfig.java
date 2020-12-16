package com.example.demo.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

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
    public DataSource one() {
        return new DruidDataSource();
    }

    @Bean(name = "twoDataSource")
    @ConfigurationProperties(prefix = "mybatis.two")
    public DataSource two() {
        return new DruidDataSource();
    }
}
