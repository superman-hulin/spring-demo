package service.impl;

import dao.AccountDao;
import dao.impl.AccouuntDaoImpl;
import service.AccountService;

/**
 * @program: factory_model
 * @description: 保存账户实现类
 * @author: Mr.Wang
 * @create: 2020-05-18 19:02
 **/
public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;
    //set方法注入
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void save() {
        accountDao.save();
    }
}
