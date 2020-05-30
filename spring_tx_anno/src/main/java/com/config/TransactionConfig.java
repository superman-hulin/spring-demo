package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * @program: spring_tx_anno
 * @description: 事务管理器配置类  相当于bean.xml中配置事务管理器的标签
 * @author: Su
 * @create: 2020-05-31 00:06
 **/
public class TransactionConfig {
    @Bean(name = "transactionManager")
    public PlatformTransactionManager getTransactionManager(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }
}
