package org.hstn.persistence_context;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.hstn.persistence_context.entity.Teacher;

public class FirstLevelEx {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {

//            transaction.begin();
            Teacher teacher1 = entityManager.find(Teacher.class, 3);
//            transaction.commit();

//            transaction.begin();
            Teacher teacher2 = entityManager.find(Teacher.class, 3);
//            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (entityManager != null) {
                entityManager.close();
                entityManager.close();
            }
        }

    }
}
