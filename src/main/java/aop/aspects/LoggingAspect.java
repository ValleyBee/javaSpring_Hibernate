package aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    public void beforeGetBookAdvice(){
        System.out.println("beforeGetBookAdvice: attempt to get a book");
    }
}
