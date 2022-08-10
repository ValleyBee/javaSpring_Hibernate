package hibernate_many_to_many;

import hibernate_many_to_many.entity.Child;
import hibernate_many_to_many.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();
        Session session = null;

        try {
            session = factory.getCurrentSession();
            session.beginTransaction();

Section sec1 = new Section("football");
Section sec2 = new Section("baseball");
Child child1 = new Child("Mark",10);
Child child2 = new Child("Yakiv",5);
Child child3 = new Child("Julia",12);

sec1.addChildSection(child1);
sec1.addChildSection(child2);
sec2.addChildSection(child1);
sec2.addChildSection(child3);

session.save(sec1);
session.save(sec2);


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
