package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @program: proxy
 * @description: 消费者
 * @author: Su
 * @create: 2020-05-28 16:08
 **/
public class Customer {
    public static void main(String[] args) {
        final Producer producer=new Producer();
        /*
        动态代理分类：
            基于接口的动态代理
                使用Proxy类中的newProxyInstance方法
                方法的参数：
                  ClassLoader：类加载器
                    用于加载代理对象字节码的，和被代理对象使用相同的类加载器
                  Class[]
                     用于让代理对象和被代理对象有相同的方法（传入被代理对象的接口的class即可）
                  InvocationHandler
                     用于提供增强的代码
            基于子类的动态代理
               当producer不实现任何接口时，我们就不能通过上面那种proxy方式进行动态代理了
               需要导入cglib的依赖
         */
        IProducer proxyProducer=(IProducer) Proxy.newProxyInstance(producer.getClass().getClassLoader(), producer.getClass().getInterfaces(), new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object value=null;
                Float money=(Float) args[0];
                if("sale".equals(method.getName())){
                   value=method.invoke(producer,money*0.8f);
                }
                return value;
            }
        });
        proxyProducer.sale(10000f);
    }
}
