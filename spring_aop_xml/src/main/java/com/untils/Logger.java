package com.untils;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @program: spring_aop_xml
 * @description: 用于记录日志的工具类，里面提供了公共的代码
 * @author: Su
 * @create: 2020-05-29 21:15
 **/
public class Logger {
    /**
    * @Autor:Su
    * @Description 用于打印日志，计划在切入点方法执行之前执行（切入点方法就是业务层的方法）
    * @Param
    */
    //前置通知 在切入点方法执行之前执行
    public void beforePrintLog(){
        System.out.println("Logger类中的beforePrintLog方法开始记录日志了");
    }
    //后置通知 在切入点方法正常执行之后执行
    public void afterPrintLog(){
        System.out.println("Logger类中的afterprintLog方法开始记录日志了");
    }
    //异常通知 在切入点方法执行产生异常之后执行
    public void throwingPrintLog(){
        System.out.println("Logger类中的throwingPrintLog方法开始记录日志了");
    }
    //最终通知 无论切入点方法是否正常执行 它都会在其后面执行
    public void finalPrintLog(){
        System.out.println("Logger类中的finalPrintLog方法开始记录日志了");
    }
    /*环绕通知
        当将这个方法在bean.xml中配置成了环绕通知的话,调用业务层代码会出现如下问题：
          切入点方法未执行（即业务层方法并未执行，只执行了该方法）
     */
    public void aroundPrintLog(){
        System.out.println("Logger类中的aroundPrintLog方法开始记录日志了");
    }
    /*上述问题的原因在于该环绕通知中没有切入点方法调用
      解决：
         spring为我们提供接口ProceedingJoinPoint。该接口有一个方法proceed（），
        该方法相当于明确调用切入点方法。该接口可以作为环绕通知的方法参数，在程序执行时，spring
        会为我们提供该接口的实现类供我们使用
      之前四种通知类型都是通过配置方式，spring中的环绕通知：
         它是spring为我们提供的一种可以在代码中手动控制增强方法何时执行的方式。也就是说我们实现四种通知类型可以靠在bean.xml中配置，
        也可以使用spring的这种环绕通知来手动完成。

     */
    public Object aroundPrintLog(ProceedingJoinPoint pjp){
        Object value=null;
        try{
            Object[] args=pjp.getArgs();//得到方法执行所需的参数
            System.out.println("Logger类中的aroundPrintLog方法开始记录日志了");//该增强代码写在proceed方法之前 就是前置通知
            value=pjp.proceed(args);//明确调用业务层方法(切入点方法)
            System.out.println("Logger类中的aroundPrintLog方法开始记录日志了");//后置通知
            return value;
        }catch (Throwable throwable){
            System.out.println("Logger类中的aroundPrintLog方法开始记录日志了");//异常通知
            throw  new RuntimeException(throwable);

        }finally {
            System.out.println("Logger类中的aroundPrintLog方法开始记录日志了");//最终通知
        }

    }


}
