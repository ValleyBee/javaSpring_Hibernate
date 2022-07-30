package aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        University university = context.getBean("university", University.class);
        university.addStudent();
        try {
            List<Student> studentList = university.getStudentList();

            System.out.println("--------------------------------");
            System.out.println(studentList);
        }
        catch(Exception e){
            System.out.println( "Caught exception : " + e);
        }
        context.close();

    }

}
