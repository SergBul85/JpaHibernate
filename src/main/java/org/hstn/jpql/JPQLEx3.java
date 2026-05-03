package org.hstn.jpql;

import jakarta.persistence.*;
import org.hstn.jpql.entity.Student;

import java.util.List;

public class JPQLEx3 {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();

            //region POSITION PARAMETER
//            Query query = entityManager.createQuery("Select s from Student as s " +
//                    "where s.name  LIKE ?1 and s.avgGrade > ?2 ");
//            query.setParameter(1,"%l%");
//            query.setParameter(2,8.5);
//
//            List<Student> resultList = query.getResultList();
//            resultList.forEach(System.out::println);
            //endregion AVG AVG

            //region NAMED PARAMETER
//            Query query = entityManager.createQuery("Select s from Student as s " +
//                    "where s.name  LIKE :letter and s.avgGrade > :grade ");
//            query.setParameter("letter", "%l%");
//            query.setParameter("grade", 8.5);
//
//            List<Student> resultList = query.getResultList();
//            resultList.forEach(System.out::println);
            //endregion AVG AVG

            //region UPDATE
//            Query query = entityManager.createQuery("update Student as s set avgGrade = 7.77 " +
//                    "where  length(s.surname) > :length");
//            query.setParameter("length", 6);
//            query.executeUpdate();
            //endregion AVG AVG

            //region DELETE
//            Query query = entityManager.createQuery("delete Student as s " +
//                    "where  s.avgGrade < :avgGrade or s.avgGrade is null or s.avgGrade = 7.77" );
//            query.setParameter("avgGrade", 7.5);
//            int i = query.executeUpdate();
//            System.out.println(i + " records deleted.");
            //endregion AVG AVG

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
