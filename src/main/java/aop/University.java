package aop;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class University {
    private List<Student> studentList = new ArrayList<>();


    public void addStudent(){
Student st1 = new Student("MarkBer",1,100.00);
Student st2 = new Student("Jacub",1,99.99);
Student st3 = new Student("Julia",8,300.00);
studentList.add(st1);
studentList.add(st2);
studentList.add(st3);
    }

    public List<Student> getStudentList () {
        System.out.println("started method getStudentList");
        System.out.println(studentList.get(9));
        System.out.println("information from method getStudents");
        System.out.println(studentList);
        return studentList;

    }

}
