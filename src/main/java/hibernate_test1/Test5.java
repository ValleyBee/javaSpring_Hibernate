 /* add to database and  get from database in one session
  * get any object from db by HQL  */
 package hibernate_test1;


 import hibernate_test1.entity.Employee;
 import org.hibernate.Session;
 import org.hibernate.SessionFactory;
 import org.hibernate.cfg.Configuration;

 public class Test5 {
     public static void main(String[] args) {

         SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
         try {

             Session session = factory.getCurrentSession();
             session.beginTransaction();
             /* SQL way */
//        Employee emp = session.get(Employee.class ,4);
//        session.delete(emp);
             /* HQL way */
             session.createQuery("delete Employee where id = 5").executeUpdate();
             session.getTransaction().commit();


             System.out.println("operation with database done");

         } finally {
             factory.close();
         }


     }

 }
