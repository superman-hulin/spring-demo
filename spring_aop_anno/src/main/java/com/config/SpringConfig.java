package com.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @program: spring_aop_anno
 * @description: spring的主配置类，用于替代掉bean.xml中仅剩的标签
 * @author: Su
 * @create: 2020-05-30 15:47
 **/
@Configuration
@ComponentScan(basePackages = "com")
@EnableAspectJAutoProxy //开启基于注解的sop支持
public class SpringConfig {
}
