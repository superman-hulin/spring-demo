package service.impl;

import dao.AccountDao;
import dao.impl.AccouuntDaoImpl;
import factory.BeanFactory;
import service.AccountService;

/**
 * @program: factory_model
 * @description: 保存账户实现类
 * @author: Mr.Wang
 * @create: 2020-05-18 19:02
 **/
public class AccountServiceImpl implements AccountService {
    //private AccountDao accountDao=new AccouuntDaoImpl();
    private AccountDao accountDao=(AccountDao)BeanFactory.getBean("accountDao");
    public void save() {
        //accountDao.save();
        for(int i=1;i<6;i++){
            System.out.println(accountDao);
        }
    }
}
