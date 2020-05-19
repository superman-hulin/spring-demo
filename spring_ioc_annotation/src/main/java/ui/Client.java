package ui;
import config.SpringConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.AccountService;

/**
 * @program: factory_model
 * @description:模拟表现层
 * @author: Mr.Wang
 * @create: 2020-05-18 19:00
 **/

public class Client {
    /**
    * @Autor:Su
    * @Description
    * @Param
    */
    public static void main(String[] args) {
        //获取核心容器对象
        //ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        /*
         当全部使用注解，不需要bean.xml时，删掉xml后，上面获取容器的就不适用了，而是采用下面的方式获取
         参数传的是主配置类的字节码(这样spring才会去读这个主配置类)
         */
        ApplicationContext ac=new AnnotationConfigApplicationContext(SpringConfig.class);
        //根据id获取对象
        AccountService accountService=(AccountService) ac.getBean("accountServiceImpl");
        accountService.save();
        System.out.println(accountService);
    }
}
