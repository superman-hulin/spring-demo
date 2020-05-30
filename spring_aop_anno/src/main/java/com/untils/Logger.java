package com.untils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @program: spring_aop_xml
 * @description: 用于记录日志的工具类，里面提供了公共的代码
 *   当使用基于注解的aop时，运行时，最终通知的代码会在异常或者后置通知之前执行。
 *    解决：我们使用spring的环绕通知的方式来运行，就会是正常顺序（因为执行代码的先后是我们自己写的）
 * @author: Su
 * @create: 2020-05-29 21:15
 **/
@Component("logger")
@Aspect //表示当前类是一个切面类
public class Logger {
    @Pointcut("execution(* com.service.impl.*.*(..))")
    private void pt(){}
    /**
    * @Autor:Su
    * @Description 用于打印日志，计划在切入点方法执行之前执行（切入点方法就是业务层的方法）
    * @Param
    */
    //前置通知 在切入点方法执行之前执行
    @Before("pt()")
    public void beforePrintLog(){
        System.out.println("Logger类中的beforePrintLog方法开始记录日志了");
    }
    //后置通知 在切入点方法正常执行之后执行
    @AfterReturning
    public void afterPrintLog(){
        System.out.println("Logger类中的afterprintLog方法开始记录日志了");
    }
    //异常通知 在切入点方法执行产生异常之后执行
    @AfterThrowing
    public void throwingPrintLog(){
        System.out.println("Logger类中的throwingPrintLog方法开始记录日志了");
    }
    //最终通知 无论切入点方法是否正常执行 它都会在其后面执行
    @After("pt()")
    public void finalPrintLog(){
        System.out.println("Logger类中的finalPrintLog方法开始记录日志了");
    }

    @Around("pt()")
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
