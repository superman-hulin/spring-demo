package service;

import pojo.Account;

public interface AccountService {
    void save(Account account);
    void transfer(String source,String target,Float money);
}
