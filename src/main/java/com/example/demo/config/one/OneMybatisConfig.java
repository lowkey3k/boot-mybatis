package com.example.demo.config.one;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.annotation.Resource;

/**
 * @author haitao.li
 * @title: OneDataSource
 * @description:
 * @date 2020/12/169:44
 */
@Configuration
@MapperScan(basePackages = "com.example.demo.mapper.one"
        , sqlSessionFactoryRef = "oneSqlSessionFactory"
        , sqlSessionTemplateRef = "oneSqlSessionTemplate")
public class OneMybatisConfig {

    @Resource(name = "oneDataSource")
    private DruidDataSource dataSource;

    @Bean("oneSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory() {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        try {
            sqlSessionFactoryBean.setMapperLocations(
                    // 设置mybatis的xml所在位置
                    new PathMatchingResourcePatternResolver().getResources("classpath*:mapping/one/*Mapper.xml"));
            return sqlSessionFactoryBean.getObject();
        } catch (Exception e) {
            return null;
        }
    }

    @Bean("oneSqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("oneSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
