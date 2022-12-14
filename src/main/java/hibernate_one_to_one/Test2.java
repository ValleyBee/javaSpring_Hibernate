/* since we added Attribute @OneToOne(mappedBy = "empDetails")  relation between classes became Bi direction.
now we can save all data to database by table 'details'
  */
package hibernate_one_to_one;


import hibernate_one_to_one.entity.Detail;
import hibernate_one_to_one.entity.Employee;
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

            /* Even if tables are joined for correct operations (insert,update,delete) call method sets for both classes */
//            employee.setEmpDetails(detail);
//            detail.setEmployee(employee);

            Detail detailInfo = session.get(Detail.class,6);
            // detailInfo.getEmployee().setEmpDetails(null);


            //   Employee employeeInfo = session.get(Employee.class,12);
            // employeeInfo.setEmpDetails(detail);

            /* because of Cascade.ALL data will change in all Joined tables */
            // session.save(detail);
            /* because of Cascade.ALL data will change in all Joined tables */

             // session.delete(detailInfo);




            System.out.println(detailInfo.getEmployee() + "\n" + detailInfo);

            /* how delete only details of Employee ?
            detailInfo.getEmployee().setEmpDetails(null);
            session.delete(detailInfo); */

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


