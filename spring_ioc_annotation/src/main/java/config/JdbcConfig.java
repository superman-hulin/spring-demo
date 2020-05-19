package config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

/**
 * @program: spring_ioc_annotation
 * @description: jdbc
 * @author: Su
 * @create: 2020-05-19 17:54
 **/
public class JdbcConfig {
    //以jdbc.url为key去properties配置文件中找对应的value并赋值给url变量，但是去配置文件读需要依靠@PropertySource注解
    @Value("${jdbc.url}")
    private String url;
    @Bean
    public Object get(){
        return null;
    }
}
