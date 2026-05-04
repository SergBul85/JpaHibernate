package org.hstn.jpql;

import jakarta.persistence.*;
import org.hstn.jpql.entity.Student;

import java.util.List;

public class NativeQueryEx1 {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {

//            Query query = entityManager.createNativeQuery("select * from students", Student.class);
//            List<Student> resultList = query.getResultList();
//            resultList.stream().forEach(System.out::println);

//            Query query = entityManager.createNativeQuery("select * from students " +
//                    "where avg_grade > ?1 and length(name) = ?2 ", Student.class);
//            query.setParameter(1, 8);
//            query.setParameter(2, 5);
//            List<Student> resultList = query.getResultList();
//            resultList.forEach(System.out::println);

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
