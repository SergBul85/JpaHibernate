package org.hstn.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hstn.hibernate.entity.Student;

import java.util.List;

public class HibernateEx {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        Transaction transaction = session.getTransaction();

        try {
            transaction.begin();

            //region ALL STUDENTS
//            Query<Student> query = session.createQuery("from Student");
//            List<Student> resultList = query.getResultList();
//            resultList.forEach(System.out::println);
            //endregion

            //region ALL STUDENTS NAME WITH 'l' AND  AVG >8
//            Query<Student> query = session.createQuery("from Student s " +
//                    "where s.name like :firstName and s.avgGrade > :avgGrade");
//            query.setParameter("firstName", "%c%");
//            query.setParameter("avgGrade", 8);
//            List<Student> resultList = query.getResultList();
//            resultList.forEach(System.out::println);
            //endregion

            //region UPDATE
//            Query query = session.createQuery("update Student s set s.avgGrade = 10.0 " +
//                    "where length(s.name) = 5 ");
//            int i = query.executeUpdate();
//            System.out.println(i);
            //endregion

            //region DELETE
//            Query query = session.createQuery("delete Student s " +
//                    "where s.avgGrade < :value");
//            query.setParameter("value", 9);
//            int i = query.executeUpdate();
//            System.out.println(i);
            //endregion

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
