/* add table with Foreign Key to a database
 by @OneToOne Uni direction relation */
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

//            Department department = new Department("IT", 500, 1200);
//            Employee emp1 = new Employee("Mark", "Bersh", 500);
//            Employee emp2 = new Employee("Yakiv", "Bersh", 300);
//
//            department.addEmpsToDepartment(emp1);
//            department.addEmpsToDepartment(emp2);
//            session.save(department);

/***************************** get all info about Employee by its id or by department *****************************************/
            Department departmentInfo = session.get(Department.class, 1);
            System.out.println(departmentInfo);
            System.out.println(departmentInfo.getEmps());

            System.out.println("-------------------------------------------------");
            Employee employeeInfo = session.get(Employee.class,1);
            System.out.println(employeeInfo);
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
