package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * @program: spring_ioc_annotation
 * @description: spring的配置类，它的作用和bean.xml是一样的
 * @author: Su
 * @create: 2020-05-19 17:18
 **/
@Configuration //被这个注解标识的类是不需要额外写扫描的，而是自动会被扫描进去读里面的注解
@ComponentScan(basePackages = {"service","dao"}) //有了该注解，bean.xml中的扫描包标签就不需要了
@Import(JdbcConfig.class) //jdbcConfig被这样导入后，则jdbcConfig中不需要写configuration注解也不需要放到扫描包里了，如果写了configuration注解（并且还需要加到主配置类中的扫描包里，该类才会被读取），则不需要这样被import也会生效
@PropertySource("classpath:jdbc.properties")//使用classpath:来声明是类路径
public class SpringConfig {
}
