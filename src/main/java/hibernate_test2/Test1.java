/* add table with Foreign Key to a database
*  */
package hibernate_test2;


import hibernate_test2.entity.Detail;
import hibernate_test2.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).addAnnotatedClass(Detail.class).buildSessionFactory();
        try {

            Employee employee = new Employee("ALex","Valev","Sales",5000);
            Detail detail = new Detail("Lviv","098364785","alex@gmail.com");
            employee.setEmpDetails(detail);


            Session session = factory.getCurrentSession();
            session.beginTransaction();
            session.save(employee);


            session.getTransaction().commit();
            System.out.println("operation with database done");

        } finally {
            factory.close();
        }


    }

}
