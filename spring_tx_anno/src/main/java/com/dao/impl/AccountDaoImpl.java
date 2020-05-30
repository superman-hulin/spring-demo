package com.dao.impl;

import com.dao.AccountDao;
import com.pojo.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @program: spring_tx_xml
 * @description: 账户dao的实现类
 * @author: Su
 * @create: 2020-05-30 22:43
 **/
@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Account findAccountById(Integer id) {
        return null;
    }

}
