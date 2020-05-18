package ui;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.AccountService;
import service.impl.DependentTestCon;
import service.impl.DependentTestSet;

/**
 * @program: factory_model
 * @description:模拟表现层
 * @author: Mr.Wang
 * @create: 2020-05-18 19:00
 **/
/*
工厂模式解耦：
    1.创建一个装bean的容器
    2.通过反射创建对象
 */
public class Client {
    /**
    * @Autor:Su
    * @Description 获取spring的ioc核心容器，并根据id获取对象
     * BeanFactory :是在 getBean 的时候才会生成类的实例（延迟加载），多例对象适用
     * ApplicationContext :在加载 applicationContext.xml(容器启动)时候就会创建(立即加载)，单例对象适用
    * @Param
    */
    public static void main(String[] args) {
        //获取核心容器对象
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        //根据id获取对象
        AccountService accountService=(AccountService) ac.getBean("accountService");
        //AccountService accountService=ac.getBean("accountService",AccountService.class);
        DependentTestCon dependentTestCon =(DependentTestCon) ac.getBean("dependentTestCon");
        DependentTestSet dependentTestSet=(DependentTestSet) ac.getBean("dependentTestSet");
        dependentTestSet.save();
        dependentTestCon.save();
        accountService.save();
    }
}
