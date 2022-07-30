package aop.aspects;

import aop.Student;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
public class UniversityLoggingAspect {
    @Before("execution(* getStudentList())")
    public void beforeGetStudentLoggingAdvice() {
        System.out.println("beforeGetStudentLoggingAdvice: Logging get " + " before method Students List");
        System.out.println("---------------------------------------------------");
    }

    @AfterReturning(pointcut = "execution(* getStudentList())", returning = "listStudents")
    public void afterReturnGetStudentLoggingAdvice(List<Student> listStudents) {
        Student firstStudent = listStudents.get(0);
        String name = firstStudent.getNameSurname();
        name = "Mr." + name;
        firstStudent.setNameSurname(name);
        System.out.println("afterReturnGetStudentLoggingAdvice: Logging get " + " after method Students List");
        System.out.println("---------------------------------------------------");
    }

    @AfterThrowing(pointcut = "execution(* getStudentList())", throwing = "exception")
    public void afterThrowingGetStudentLoggingAdvice(Throwable exception) {
        System.out.println("afterThrowingGetStudentLoggingAdvice: Logging throwing = " + exception);
        System.out.println("---------------------------------------------------");

    }

    @After("execution(* getStudentList())")
    public void afterGetStudentLoggingAdvice(JoinPoint joinPoint) {
        System.out.println("afterGetStudentLoggingAdvice : " + " Logging normal or throw ending of code");
        System.out.println("joinPoint getSignature : " + joinPoint.getSignature());
        System.out.println("---------------------------------------------------");
    }

}
