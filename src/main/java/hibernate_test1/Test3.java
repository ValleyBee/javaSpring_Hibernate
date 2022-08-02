 /* add to database and  get from database in one session
 * get any object from db by HQL  */
package hibernate_test1;


import hibernate_test1.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

 public class Test3 {
     public static void main(String[] args) {

         SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
         try {
             /* add to database */
             Session session = factory.getCurrentSession();
             session.beginTransaction();
             List<Employee> employeeList = session.createQuery("from Employee").getResultList();

             employeeList.forEach(System.out::println);

             session.getTransaction().commit();
             /* save is INSERT SQL */


             /* get from database */


 /* get from table by SELECT and convert data to Object Employee
 get object by ID
  get is SELECT SQL */



             System.out.println("operation with database done");

         } finally {
             factory.close();
         }


     }

 }
