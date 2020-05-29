package service.impl;

import dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Account;
import service.AccountService;
import utils.TransactionManager;

/**
 * @program: proxy
 * @description: 账户业务实现类
 * 事务控制应该都在业务层
 * @author: Su
 * @create: 2020-05-25 19:44
 **/
@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;
    @Autowired
    private TransactionManager transactionManager;
    /**
    * @Autor:Su
    * @Description 这段事务控制的代码应该在业务层每个方法中都要有
     * 我们通过基于接口的动态代理来对该业务类的方法进行增强（添加这些事务的操作）,这样该类中的事务代码就不需要了
    * @Param
    */
    public void save(Account account) {
        try{
            //开启事务
            transactionManager.beginTransaction();
            //执行操作
            accountDao.insert(account);
            //提交事务
            transactionManager.commitTransaction();
            //返回结果
        }catch (Exception e){
            //回滚操作
            transactionManager.rollbackTransaction();
            throw new RuntimeException(e);
        }finally {
            //释放连接
            transactionManager.releaseTransaction();
        }
    }

    public void transfer(String source, String target, Float money) {
        //1.根据名称查询转出账户
        //2.根据名称查询转入账户
        //3.转出账户减钱
        //4.转入账户加钱
        //5.更新转出账户
        //如果在这个地方出现了代码异常（如加行代码int a=1/0），则钱减了，但是没有相应的加钱
        //1.2.5.6四个步骤都会获取一个数据库连接，相当于四个连接。
        //解决该问题：将这四个步骤变成一个数据库连接，那么这四个步骤要成功就会一起成功，要有一个失败，则一起失败。
        //使用ThreadLocal对象把Connection和当前线程绑定，从而使一个线程中只有一个能控制事务的对象
        //6.更新转入账户

    }
}
