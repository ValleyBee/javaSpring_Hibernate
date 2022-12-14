/* @OneToMany bi Uni direction relation */
package hibernate_one_to_many_bi;


import hibernate_one_to_many_bi.entity.Department;
import hibernate_one_to_many_bi.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).addAnnotatedClass(Department.class).buildSessionFactory();
        Session session = null;

        try {
            session = factory.getCurrentSession();
            session.beginTransaction();

//            Department department = new Department("Sales", 300, 1000);
//            Employee emp1 = new Employee("Alex", "Moon", 300);
//            Employee emp2 = new Employee("James", "Springson", 200);
//
//            department.addEmpsToDepartment(emp1);
//            department.addEmpsToDepartment(emp2);
//            session.save(department);
//            session.save(emp1);
//            session.save(emp2);


/***************************** get all info about Employee by its id or by department *****************************************/


            Department departmentInfo = session.get(Department.class, 2);

            System.out.println("--------------------------------------------------------------------------");
            System.out.println(departmentInfo);
            System.out.println("--------------------------------------------------------------------------");
            System.out.println(departmentInfo.getEmps());

            System.out.println("--------------------------------------------------------------------------");
            Employee employeeInfo = session.get(Employee.class, 3);

            System.out.println(employeeInfo);
            System.out.println("--------------------------------------------------------------------------");
            System.out.println(employeeInfo.getDepartment());


            session.getTransaction().commit();
            System.out.println("operation with database done");

        } finally {
            /* to handle ERROR: "Connection leak detected: there are 1 unclosed connections upon shutting down"
             * session has to close first than factory */
            assert session != null;
            session.close();
            System.out.println("session close");
            factory.close();
            System.out.println("factory close");


        }


    }

}
