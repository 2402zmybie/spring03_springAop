package com.hr.service.utils;

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


}
