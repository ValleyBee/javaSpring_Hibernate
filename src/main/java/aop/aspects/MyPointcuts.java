package aop.aspects;

import org.aspectj.lang.annotation.Pointcut;


public class MyPointcuts {

    // POINTCUT I
// SECURITY AND LOGGING ASPECTS

    @Pointcut("execution(* __get* (*))") //  Test1 CLass.  to use replace __get* > get*.
    public void allGetMethods(){}

    @Pointcut("execution(* add* (..))") // Test2 Class
    public void allAddMethods(){}
}
