package org.hstn.persistence_context;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.hstn.persistence_context.entity.Teacher;

public class TransactionEx2 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Teacher teacher1 = new Teacher("Landry", "Shelton", "Econiomics", true);
            Teacher teacher2 = new Teacher("Vera", "Valton", "Geography", true);

            entityManager.persist(teacher1);

            Teacher teacher3 = entityManager.find(Teacher.class, 100);
            System.out.println(teacher3.getSubject() + " " + teacher1.getSubject());

            entityManager.persist(teacher2);

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                System.out.println("Rollback !!!!");
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
