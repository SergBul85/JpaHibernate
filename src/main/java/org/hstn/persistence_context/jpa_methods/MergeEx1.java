package org.hstn.persistence_context.jpa_methods;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.hstn.persistence_context.entity.Teacher;

public class MergeEx1 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();

            Teacher teacher = new Teacher("Vera", "Walton", "Geo", true);
            entityManager.persist(teacher);

            transaction.commit();
            entityManager.close();
//--------------------------------------------------------------------------------
            teacher.setSubject("Math");
            entityManager = emf.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

//            entityManager.persist(teacher);
            Teacher mergedTeacher = entityManager.merge(teacher);

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                System.out.println("Rollback");
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (entityManager != null) {
                entityManager.close();
                emf.close();
            }
        }
    }
}