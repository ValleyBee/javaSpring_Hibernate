/* Upgrade current table with new field details (Foreign Key) referenced to a table
by @OneToOne Uni direction relation
  */
package hibernate_one_to_one;


import hibernate_one_to_one.entity.Detail;
import hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test11 {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).addAnnotatedClass(Detail.class).buildSessionFactory();

        /* to handle ERROR: "Connection leak detected: there are 1 unclosed connections upon shutting down" */
        Session session = null;


        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            Employee employee = session.get(Employee.class,12); // serial it's PK
            Detail detail = new Detail("Canada","096000005","employee@yahoo.com");

            //employee.setEmpDetails();
            System.out.println(employee.getEmpDetails());

            employee.setEmpDetails(detail);

            // session.save(employee);  /* by @OneToOne(cascade = CascadeType.ALL)  type Cascade - means changing will be done in all related tables */
            //session.delete(employee);


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
