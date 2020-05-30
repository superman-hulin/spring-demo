package com.service;

import com.pojo.Account;

public interface AccountService {
    Account findAccountById(Integer id);
    void transfer(String source,String target,Float money);
}
