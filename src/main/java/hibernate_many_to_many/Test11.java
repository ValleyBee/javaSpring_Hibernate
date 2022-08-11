package hibernate_many_to_many;

import hibernate_many_to_many.entity.Child;
import hibernate_many_to_many.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test11 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();
        Session session = null;

        try {
            session = factory.getCurrentSession();
            session.beginTransaction();

            Child child = session.get(Child.class,5);
            Section section = session.get(Section.class,1);

            System.out.println(child.getSectionList());
            System.out.println("----------------------------------------------------------------------");
            System.out.println(section.getChildList());

            //            session.delete(child);

            session.getTransaction().commit();

        } finally {
            assert session != null;
            session.close();
            System.out.println("session close");
            factory.close();
            System.out.println("factory close");
        }
    }
}
