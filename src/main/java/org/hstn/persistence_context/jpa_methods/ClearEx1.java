package org.hstn.persistence_context.jpa_methods;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.hstn.persistence_context.entity.Teacher;

public class ClearEx1 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();

            Teacher teacher1 = entityManager.find(Teacher.class, 1);
            Teacher teacher3 = entityManager.find(Teacher.class, 3);
            Teacher teacher4 = entityManager.find(Teacher.class, 4);
            entityManager.clear();

            teacher1.setSubject("aaa");
            teacher3.setName("bbbbbb");
            teacher4.setSurname("ccccccccc");

            System.out.println(teacher1);
            System.out.println(teacher3);
            System.out.println(teacher4);

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