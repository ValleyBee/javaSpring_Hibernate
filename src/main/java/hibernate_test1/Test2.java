 /* add to database and  get from database in one session
 * get object from db by ID */
package hibernate_test1;


import hibernate_test1.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
        try {
            /* add to database */
            Session session = factory.getCurrentSession();
            Employee emp = new Employee("Abel", "Adam", "Sales", 2550);
            session.beginTransaction();
            /* save is INSERT SQL */
            session.save(emp);

            /* get from database */
            int myId = emp.getId();

/* get from table by SELECT and convert data to Object Employee
get object by ID
 get is SELECT SQL */
            Employee employee = session.get(Employee.class, myId);
            session.getTransaction().commit();
            System.out.println(employee);


            System.out.println("operation with database done");

        } finally {
            factory.close();
        }


    }

}
