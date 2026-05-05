package org.hstn.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hstn.hibernate.entity.Student;

public class HibernateEx3 {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        Transaction transaction = session.getTransaction();

//        SessionFactory factory = new Configuration()
//                .configure("hibernate.cfg.xml")
//                .addAnnotatedClass(Student.class)
//                .buildSessionFactory();
//
//        Session session = factory.getCurrentSession();
//        Transaction transaction = session.getTransaction();

        try {
            transaction.begin();

            Student student1 = session.get(Student.class, 3);
            student1.setAvgGrade(9.0);

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
