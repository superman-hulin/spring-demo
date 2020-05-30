package com.dao;

import com.pojo.Account;

public interface AccountDao {
    Account findAccountById(Integer id);
}
