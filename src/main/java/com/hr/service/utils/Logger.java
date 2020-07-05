package com.hr.service.utils;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 日志工具类
 */
public class Logger {

    public void printLog() {
        System.out.println("Logger类中的printLog方法开始记录日志了");
    }

    /**
     * 打印日志, 计划让其在切入点方法执行之前执行(切入点方法就是要被增强的业务层方法)
     * 前置通知
     */
    public void beforPrintLog() {
        System.out.println("前置通知Logger类中的beforPrintLog方法开始记录日志了");
    }

    /**
     * 后置通知
     */
    public void afterReturnPrintLog() {
        System.out.println("后置通知Logger类中的beforPrintLog方法开始记录日志了");
    }

    /**
     * 异常通知
     */
    public void afterThrowingPrintLog() {
        System.out.println("异常通知Logger类中的beforPrintLog方法开始记录日志了");
    }

    /**
     * 最终通知
     */
    public void afterPrintLog() {
        System.out.println("最终通知Logger类中的beforPrintLog方法开始记录日志了");
    }

    /**
     * 环绕通知
     * 问题:
     *  当配置了环绕通知之后,切入点方法没有执行,而通知方法执行了
     * 分析:
     *  通过对比动态代理中环绕通知的代码,发现动态代理的环绕通知有明确的切入点方法调用,而我们的代码没有
     *  解决:
     *      Spring框架为我们提供了一个接口,ProceedingJoinPoint, 该接口有一个方法proceed(),此方法就相当于明确调用切入点方法
     *      该接口可以作为环绕通知的方法参数, 在程序执行时,spring会为我们提供该接口的实现类供我们使用
     * spring环绕通知作用:
     *      它是spring框架为我们提供的一种可以在代码中手动控制增强方法何时执行的方式
     */
    public Object aroundPrintLog(ProceedingJoinPoint pjp) {
        Object rtValue = null;
        try {
            Object[] args = pjp.getArgs();

            System.out.println("Logger类中的aroundPrintLog方法开始记录日志了...前置");

            rtValue = pjp.proceed(args);   //明确调用业务层方法(切入点方法)

            System.out.println("Logger类中的aroundPrintLog方法开始记录日志了... 后置");
            return rtValue;
        } catch (Throwable throwable) {
            System.out.println("Logger类中的aroundPrintLog方法开始记录日志了... 异常");
            throw new RuntimeException(throwable);
        }finally {
            System.out.println("Logger类中的aroundPrintLog方法开始记录日志了... 最终");
        }

    }


}
