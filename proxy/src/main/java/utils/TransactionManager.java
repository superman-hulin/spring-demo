package utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * @program: proxy
 * @description: 事务管理类
 * @author: Su
 * @create: 2020-05-28 14:30
 **/
@Component
public class TransactionManager {
    @Autowired
    private ConnectionUtil connectionUtil;
    /**
    * @Autor:Su
    * @Description 开始事务
    * @Param
    */
    public void beginTransaction(){
        try {
            connectionUtil.getThreadConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * @Autor:Su
     * @Description 提交事务
     * @Param
     */
    public void commitTransaction(){
        try {
            connectionUtil.getThreadConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * @Autor:Su
     * @Description 回滚事务
     * @Param
     */
    public void rollbackTransaction(){
        try {
            connectionUtil.getThreadConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * @Autor:Su
     * @Description 释放事务
     * @Param
     */
    public void releaseTransaction(){
        try {
            connectionUtil.getThreadConnection().close();//关闭连接是指将连接还回连接池中
            //使当前线程和已close的连接解绑
            connectionUtil.removeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
