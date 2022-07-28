package aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SecurityAspect {
    @Before("aop.aspects.MyPointcuts.allGetMethods()")
    private void beforeGetSecurityAdvice() {
        System.out.println("beforeGetSecurityAdvice: Checking permits attempt to do");
    }
}
