package factory;

import service.AccountService;
import service.impl.AccountServiceImpl;

/**
 * @program: spring_ioc_xml
 * @description: 工厂类
 * @author: Su
 * @create: 2020-05-18 21:18
 **/
public class BeanFactory {
    public AccountService getAccountService(){
        return new AccountServiceImpl();
    }
}
