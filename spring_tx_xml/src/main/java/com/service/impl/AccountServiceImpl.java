package com.service.impl;

import com.dao.AccountDao;
import com.pojo.Account;
import com.service.AccountService;

/**
 * @program: spring_tx_xml
 * @description: 账户的业务层实现类
 * @author: Su
 * @create: 2020-05-30 22:44
 **/
public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public Account findAccountById(Integer id) {
        return  accountDao.findAccountById(id);
    }

    public void transfer(String source, String target, Float money) {

    }
}
