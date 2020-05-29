package utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @program: proxy
 * @description: 连接的工具类，它用于从数据源中获取一个连接，并且实现和线程的绑定
 * @author: Su
 * @create: 2020-05-28 14:18
 **/
@Component
public class ConnectionUtil {
    private ThreadLocal<Connection> threadLocal=new ThreadLocal<Connection>();
    @Autowired
    private DataSource dataSource;
    /**
    * @Autor:Su
    * @Description 获取当前线程上的连接
    * @Param
    */
    public  Connection getThreadConnection(){
        //先从ThreadLocal上获取
        Connection connection=threadLocal.get();
        if (connection==null){
            //从数据源中获取一个连接，并且存入ThreadLocal中
            try {
                connection=dataSource.getConnection();
                threadLocal.set(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //返回当前线程上的连接
        return connection;
    }
    /**
     * @Autor:Su
     * @Description web工程，当tomcat启动时，会自动创建连接池和线程池，当前线程和连接绑定后，连接close后
     * 放回了连接池，但是当前线程还是和该连接是绑定的，只是该连接不能用了。所以需要将该连接解绑掉
     * @Param
     */
    public void removeConnection(){
        threadLocal.remove();
    }

}
