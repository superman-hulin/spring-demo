package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

/**
 * @program: proxy
 * @description: spring的主配置类
 * @author: Su
 * @create: 2020-05-25 20:37
 **/
@Configuration
@ComponentScan({"service","dao"})
@Import(JdbcConfig.class)
public class SpringConfig {
}
