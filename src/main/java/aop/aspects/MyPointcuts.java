package aop.aspects;

import org.aspectj.lang.annotation.Pointcut;


public class MyPointcuts {

    // POINTCUT I
// SECURITY AND LOGGING ASPECTS
    @Pointcut("execution(* get* (*))")
    public void allGetMethods(){}

    @Pointcut("execution(* add* (*))")
    public void allAddMethods(){}
}
