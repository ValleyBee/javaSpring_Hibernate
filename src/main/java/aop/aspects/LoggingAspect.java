package aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    // call method in exact Class
    @Before("execution(public void aop.Library.getBook())")
    public void beforeGetBookAdvice(){
        System.out.println("beforeGetBookAdvice: attempt to get a book from Library.");
    }
@Before("execution(public void getBook(String))")
    public void beforeGetBookAdvice2(){
        System.out.println("beforeGetBookAdvice2: attempt to get a book from UniLibrary.");
    }
    // call any method begins get* scan whole package
    @Before("execution(public void get*())")
public void anyGetMethodAdvice(){
    System.out.println("anyGetMethodAdvice: calling before any get* methods");
}
// any methods with one any arg
@Before("execution(public void * (*))")  // (..)) any qtty args
    public void anyMethodAnyArgAdvice() {
    System.out.println("anyMethodAnyArgAdvice: calling before any methods with one any arg");

}

@Before("execution(public void returnBook())")

    public void beforeReturnBookAdvice(){
        System.out.println("beforeReturnBookAdvice: attempt to return a book.");
    }

    // call any method with any type and names return*
    @Before("execution(public * return*())")

    public void beforeReturnBookAdvice2(){
        System.out.println("beforeReturnBookAdvice2: calling before any method with any type and names return*.");
    }
}
