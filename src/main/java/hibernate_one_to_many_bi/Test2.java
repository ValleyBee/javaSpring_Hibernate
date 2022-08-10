/* Lazy, Eager types of loading data from database
* Default type
* OneToOne - Eager
* OneToMany - Lazy
* ManyToOne - Eager
* ManyToMany - Lazy */

package hibernate_one_to_many_bi;


import hibernate_one_to_many_bi.entity.Department;
import hibernate_one_to_many_bi.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
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

            System.out.println("-------------- 1 Get department");
            Department departmentInfo = session.get(Department.class, 2);

            System.out.println("-------------- 2 Show department -------------------------------------------");
            System.out.println(departmentInfo);
            System.out.println("-------------  3 Show employees of department-------------------------------");
          //  departmentInfo.getEmps().get(0); // to avoid throw exception Lazy failed

            System.out.println(departmentInfo.getEmps());
            System.out.println("");
            System.out.println("-------------- 4 Get employees");

            Employee employeeInfo = session.get(Employee.class, 3);
            System.out.println("-------------- 5 Show employee --------------------------------------------");
            System.out.println(employeeInfo);
            System.out.println("-------------- 6 Show department of employees ------------------------------");
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
