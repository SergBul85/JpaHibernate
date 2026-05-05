package org.hstn.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hstn.hibernate.entity.Student;

public class HibernateEx1 {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernare.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        Transaction transaction = session.getTransaction();

        try {
            Student student = new Student("Leo", "Farrel", 8.4);

            transaction.begin();

            session.persist(student);
            System.out.println(student);

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
            factory.close();
        }
    }
}
