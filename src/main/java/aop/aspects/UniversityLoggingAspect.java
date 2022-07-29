package aop.aspects;

import aop.Student;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
public class UniversityLoggingAspect {
@Before("execution(* getStudentList())")
    public void beforeGetStudentLoggingAdvice(){
    System.out.println("beforeGetStudentLoggingAdvice: Logging get " + " before method Students List");
    }

    @AfterReturning(pointcut = "execution(* getStudentList())",returning = "listStudents")
    public void afterReturnGetStudentLoggingAdvice(List<Student> listStudents){
    Student firstStudent = listStudents.get(0);
    String name = firstStudent.getNameSurname();
    name = "Mr." + name;
    firstStudent.setNameSurname(name);


        System.out.println("afterReturnGetStudentLoggingAdvice: Logging get " + " after method Students List");
    }
}
