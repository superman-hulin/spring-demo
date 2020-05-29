package cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import proxy.IProducer;

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
            基于子类的动态代理
                使用Ehancer类中的create方法
               创建代理对象的要求：被代理类不能是最终类
                方法的参数：
                  Class：字节码
                    用于指定被代理对象的字节码
                  Callback
                     用于提供增强的代码，我们一般写的都是该接口的子接口实现类：MethodInterceptor

         */
       Producer cglibProducer=(Producer) Enhancer.create(producer.getClass(), new MethodInterceptor() {
            public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                Object value=null;
                Float money=(Float) args[0];
                if("sale".equals(method.getName())){
                    value=method.invoke(producer,money*0.8f);
                }
                return value;
            }
        });
       cglibProducer.sale(10000f);

    }
}
