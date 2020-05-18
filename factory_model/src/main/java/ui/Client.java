package ui;

import factory.BeanFactory;
import service.AccountService;
import service.impl.AccountServiceImpl;

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
    public static void main(String[] args) {
        //AccountService accountService=new AccountServiceImpl();
        //采用工厂模式来解决类依赖问题，不用new创建对象
        AccountService accountService=(AccountService)BeanFactory.getBean("accountService");
        accountService.save();
    }
}
