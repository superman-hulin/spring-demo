package service.impl;

import dao.AccountDao;
import dao.impl.AccouuntDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.AccountService;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @program:
 * @description:
 * 用于创建对象的注解：
 *      @Component 用于把当前对象存入spring容器中
 *      @Controller
 *      @Service
 *      @Repository
 * 用于注入数据的注解：
 *      @Autowired 自动按照类型注入，只要容器中有唯一的一个bean对象类型和要注入的变量类型匹配，则注入成功
 *                 如果容器中该类型有多个bean对象时，则按照类型和变量名称去找对应的bean的id进行注入
 *      @Qualifier: 在按照类型注入的基础上再按照名称注入， 它在给类成员注入时不能单独使用（必须先写@Autowired），但是在给方法参数注入时可以
 *      @Resource 直接按照bean的id注入，可以独立使用，注意是用name来指定bean的id
 * --------------以上三个注解只能注入其它bean类型的数据，集合类型的注入只能通过xml来实现----------------------
 *      @Value 用于注入基本类型和string类型的数据，使用属性value来指定数据的值（该值可以使用spring中的spel）
 *            spel的写法：${表达式}
 * 用于改变作用范围的注解：
 *      @Scope 用于指定bean的作用范围（写在类上或写在bean注解过的方法上，当不写该注解时，是默认单例），使用value属性来取值
 * 和生命周期相关的注解：
 *      @PreDestroy  用于指定销毁方法
 *      @PostConstruct 用于指定初始化方法
 * spring的新注解
 *      @Configuration 指定当前类是一个配置类
 *      @ComponentScan  用于通过注解指定spring在创建容器时要扫描的包（为了扫描到类中的注解）
 *      @Bean 用于把当前方法的返回值作为bean对象存入spring的ioc容器中，属性name用于指定bean的id（不写时的默认值是当前方法的名称）
 *           如果该方法需要其他bean对象作为参数时，则用@Qualifier注解方式注入该bean对象（如果没有，则该参数会报错）
 *      @Import  用于导入其它的配置类
 *      @PropertySource 用于指定properties文件的位置
 * @author: Mr.Wang
 * @create: 2020-05-18 19:02
 **/
@Component
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;
    @PostConstruct
    public void init(){
        System.out.println("初始化了");
    }
    public void save() {
        accountDao.save();
    }
    @PreDestroy
    public void destroy(){
        System.out.println("销毁了");
    }
}
