package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * @program: spring_tx_anno
 * @description: jdbc的配置类
 * @author: Su
 * @create: 2020-05-30 23:58
 **/
public class JdbcConfig {
    @Bean
    public JdbcTemplate getJdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
    @Bean(name = "dataSource")
    public DataSource getDataSource(){
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/account");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }
}
