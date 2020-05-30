package com.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @program: spring_tx_anno
 * @description: sping的主配置类
 * @author: Su
 * @create: 2020-05-30 23:46
 **/
@Configuration
@ComponentScan("com")
@Import({JdbcConfig.class,TransactionConfig.class})
@EnableTransactionManagement //开始spring事务控制的注解支持 相当于bean.xml中配的注解支持
public class SpringConfig {
}
