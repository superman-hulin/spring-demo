package com.pojo;

/**
 * @program: spring_tx_xml
 * @description: 账户实体类
 * @author: Su
 * @create: 2020-05-30 22:42
 **/
public class Account {
    private Integer id;
    private String accountName;
    private Float money;

    public Account(Integer id, String accountName, Float money) {
        this.id = id;
        this.accountName = accountName;
        this.money = money;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

}
