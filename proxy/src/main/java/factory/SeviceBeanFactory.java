package factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import service.AccountService;
import utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @program: proxy
 * @description: 用于创建Service的代理对象的工厂,通过该代理对象来对业务层类的方法进行增强（即增加事务控制）.
 * 该代理对象和被代理对象（即业务层类）都是业务层接口的实现类，将他们都注入到容器中，此时容器中同类型的bean会有两个。
 * 所以表现层注入业务层类时要声明bean的名称（选业务层的代理对象）
 * @author: Su
 * @create: 2020-05-28 16:51
 **/
public class SeviceBeanFactory {
    @Autowired
    private AccountService accountService;
    @Autowired
    private TransactionManager transactionManager;

    @Bean
    public AccountService getAccountService(){
        AccountService proxyAccountService=(AccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(), accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    //添加事务的支持
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object value=null;
                        try{
                            //开启事务
                            transactionManager.beginTransaction();
                            //执行操作
                            value=method.invoke(accountService,args);
                            //提交事务
                            transactionManager.commitTransaction();
                            //返回结果
                            return value;
                        }catch (Exception e){
                            //回滚操作
                            transactionManager.rollbackTransaction();
                            throw new RuntimeException(e);
                        }finally {
                            //释放连接
                            transactionManager.releaseTransaction();
                        }
                    }
                });
        return proxyAccountService;
    }
}
