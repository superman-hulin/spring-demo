package com.dao.impl;

import com.dao.AccountDao;
import com.pojo.Account;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @program: spring_tx_xml
 * @description: 账户dao的实现类
 * @author: Su
 * @create: 2020-05-30 22:43
 **/
public class AccountDaoImpl implements AccountDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Account findAccountById(Integer id) {
        return null;
    }

}
