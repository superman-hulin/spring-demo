package factory;

import service.AccountService;
import service.impl.AccountServiceImpl;

/**
 * @program: spring_ioc_xml
 * @description: 工厂中的静态方法
 * @author: Su
 * @create: 2020-05-18 21:24
 **/
public class StaticFactory {
    public static AccountService getAccountService(){
        return new AccountServiceImpl();
    }
}
