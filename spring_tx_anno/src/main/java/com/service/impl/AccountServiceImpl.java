package com.service.impl;

import com.dao.AccountDao;
import com.pojo.Account;
import com.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: spring_tx_xml
 * @description: 账户的业务层实现类
 * @author: Su
 * @create: 2020-05-30 22:44
 **/
@Service("accountService")
@Transactional(readOnly = true) //开启spring基于注解的事务支持 事务的属性在注解中给,
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

    public Account findAccountById(Integer id) {
        return  accountDao.findAccountById(id);
    }
    @Transactional(readOnly = false) //单独配读写方法的事务属性
    public void transfer(String source, String target, Float money) {

    }
}
