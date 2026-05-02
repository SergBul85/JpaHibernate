package org.hstn.persistence_context.jpa_methods;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.hstn.persistence_context.entity.Teacher;

public class FlushEx1 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();

            Teacher teacher1 = entityManager.find(Teacher.class, 1);
            Teacher teacher3 = entityManager.find(Teacher.class, 3);

            System.out.println("Update teacher 1");
            teacher1.setSubject("Bio");

            System.out.println("Flush");
            entityManager.flush();

            System.out.println("Update teacher 3");
            teacher3.setSubject("Bio");

            Teacher teacherX = entityManager.find(Teacher.class, 100);
            System.out.println(  teacherX.getName());

            System.out.println("Commit");
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