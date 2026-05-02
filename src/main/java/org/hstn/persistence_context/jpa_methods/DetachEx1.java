package org.hstn.persistence_context.jpa_methods;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.hstn.persistence_context.entity.Teacher;

public class DetachEx1 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();

            Teacher teacher = entityManager.find(Teacher.class, 1);
            System.out.println(entityManager.contains(teacher));

            entityManager.detach(teacher);
            System.out.println(entityManager.contains(teacher));
            teacher.setSubject("Geo");
            System.out.println(teacher);

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