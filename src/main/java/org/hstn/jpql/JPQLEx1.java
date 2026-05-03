package org.hstn.jpql;

import jakarta.persistence.*;
import org.hstn.jpql.entity.Student;

import java.util.List;

public class JPQLEx1 {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();

//            region ALL STUDENT
//            select * from students
//            Query query = entityManager.createQuery("select s from Student s");
//            List<Student> students = query.getResultList();
//            List<Student> students = entityManager.createQuery("select s from Student s").getResultList();
//            students.forEach(System.out::println);
//            endregion ALL STUDENT

            //region ALL STUDENT WITH NAME LEO
//            Query query = entityManager.createQuery("select s from Student s " +
//                    "where s.name = 'Leo'  ");
//            List<Student> resultList = query.getResultList();
//            resultList.forEach(System.out::println);
            //endregion ALL STUDENT WITH NAME LEO

            //region ALL STUDENT WITH AVG GRADE > 8.5
//            Query query = entityManager.createQuery("select s from Student s " +
//                    "where s.avgGrade > 8.5");
//            List<Student> students = query.getResultList();
//            students.forEach(System.out::println);
            //endregion ALL STUDENT WITH AVG GRADE > 8.5

            //region ALL STUDENT WITH AVG GRADE between 7 and 8
//            Query query = entityManager.createQuery("select s from Student s " +
//                    "where s.avgGrade between 7 and 8");
//            List<Student> students = query.getResultList();
//            students.forEach(System.out::println);
            //endregion ALL STUDENT WITH AVG GRADE between 7 and 8

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (entityManager != null) {
                entityManager.close();
                factory.close();
            }
        }

    }
}
