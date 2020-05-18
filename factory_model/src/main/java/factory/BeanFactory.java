package factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @program: factory_model
 * @description: 工厂类
 * @author: Mr.Wang
 * @create: 2020-05-18 19:07
 **/
public class BeanFactory {
    private static Properties  properties;
    // 用map作单例bean的容器
    private static Map<String,Object> map;
    static {
        properties=new Properties();
        InputStream inputStream=BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*
        为了是单例对象，则我们在静态代码块这里创建的对象（类加载的时候运行一次），要把它保存到容器中
         */
        map=new HashMap<String, Object>();
        Enumeration keys=properties.keys();
        while (keys.hasMoreElements()){
            String key=keys.nextElement().toString();
            String beanPath=properties.getProperty(key);
            try {
                Object bean=Class.forName(beanPath).newInstance();
                map.put(key,bean);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
    /*
    单例对象
     */
    public static Object getBean(String beanName) {
       return map.get(beanName);
    }

    /*
    bean=Class.forName(beanPath).newInstance();
    调用多次，会创建多个对象，多例的
     */
//    public static Object getBean(String beanName){
//       String beanPath= properties.getProperty(beanName);
//       Object bean=null;
//        try {
//            bean=Class.forName(beanPath).newInstance();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return bean;
//    }
}
