package org.hstn.persistence_context;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.hstn.persistence_context.entity.Teacher;

public class AutomaticDirtyCheckingEx2 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            Teacher teacher1 = entityManager.find(Teacher.class, 4);


            entityManager.close();

            entityManager = emf.createEntityManager();
            transaction =  entityManager.getTransaction();

            transaction.begin();

            teacher1.setSubject("Economics");

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
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
