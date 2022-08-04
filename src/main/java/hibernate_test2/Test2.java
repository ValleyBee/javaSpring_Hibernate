/* since we added Attribute @OneToOne(mappedBy = "empDetails")  relation between classes became Bi direction.
now we can save all data to database by table 'details'
  */
package hibernate_test2;


import hibernate_test2.entity.Detail;
import hibernate_test2.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).addAnnotatedClass(Detail.class).buildSessionFactory();

        /* to handle ERROR: "Connection leak detected: there are 1 unclosed connections upon shutting down" */
        Session session = null;


        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            Employee employee = new Employee("ALex","Valev","Sales",5000);
            Detail detail = new Detail("Lviv","098364785","alex@gmail.com");

            employee.setEmpDetails(detail);
            detail.setEmployee(employee);

            session.save(detail);

            System.out.println(employee.getEmpDetails());



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
