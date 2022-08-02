package hibernate_test1;


import hibernate_test1.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();
            Employee emp = new Employee("Val", "Bersh", "Owner", 4000);
            session.beginTransaction();
            session.save(emp); //INSERT SQL
            session.getTransaction().commit();
            System.out.println("operation with database done");
        } finally {
            factory.close();
        }


    }

}
