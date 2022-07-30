package aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.aspectj.lang.JoinPoint;

@Component
@Aspect
public class NewLoggingAspect {
    @Around("execution(public String returnBook2())")
    public Object aroundReturnBookLoggingAdvice(ProceedingJoinPoint pj) throws Throwable {
        System.out.println("aroundReturnBookLoggingAdvice: attempt return book to Unilib");
        System.out.println("---------------------------------------------------");
        System.out.println("Executing Before part of business method");
        System.out.println("---------------------------------------------------");
        long beginT = System.currentTimeMillis();
        Object targetMethodResult = null;
        try {
            targetMethodResult = pj.proceed(); // this code will call business method
        } catch (Exception e){
            System.out.println("aroundReturnBookLoggingAdvice: Caught exception " + e);
            throw e;
        }
        long endT = System.currentTimeMillis();
        System.out.println("Executing After part of business method");
        System.out.println("---------------------------------------------------");
        System.out.println("aroundReturnBookLoggingAdvice: method returnBook2 done within - " + (endT - beginT) + "ms");
        return targetMethodResult;
    }
}
