package client;

import config.SpringConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pojo.Account;
import service.AccountService;

/**
 * @program: proxy
 * @description: 表现层
 * @author: Su
 * @create: 2020-05-25 22:54
 **/
public class demo {
    public static void main(String[] args) {
        ApplicationContext ac=new AnnotationConfigApplicationContext(SpringConfig.class);
        //根据id获取对象
        AccountService accountService=(AccountService) ac.getBean("accountService");
        Account account=new Account();
        account.setAccountName("tingting");
        account.setMoney(1000f);
        accountService.save(account);

    }
}
