package org.hstn.jpql;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.hstn.jpql.entity.Student;

public class FlushEx1 {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
//            transaction.begin();
//
//            Student student = entityManager.find(Student.class, 1);
//            student.setAvgGrade(9.0);
//
//            Double avgGrade = entityManager.createQuery("select s.avgGrade from Student s " +
//                    "where s.id=1",  Double.class).getSingleResult();
//
//            System.out.println("avgGrade: " + avgGrade);
//
//            transaction.commit();
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
