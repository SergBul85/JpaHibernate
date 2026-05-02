package org.hstn.persistence_context;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.hstn.persistence_context.entity.Teacher;

public class TransactionEx1 {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {

            transaction.begin();
            Teacher teacher1 = entityManager.find(Teacher.class, 3);
            Teacher teacher2 = entityManager.find(Teacher.class, 4);

            teacher1.setSubject("Geo");

            Teacher teacher3 = entityManager.find(Teacher.class, 7);
            System.out.println(teacher3.getSubject());


            teacher2.setSubject("Geo");

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
