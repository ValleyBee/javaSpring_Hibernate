package aop.aspects;

import org.aspectj.lang.annotation.Before;

public class ExceptionHandlingAspect {


    @Before("aop.aspects.MyPointcuts.allGetMethods()")
    public void beforeGetExceptionHandlingAdvice(){
        System.out.println("beforeGetExceptionHandlingAdvice: catch/operate" + " exceptions before get item");
    }
}
