package org.hstn.persistence_context.jpa_methods;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.hstn.persistence_context.entity.Teacher;

public class CallBackMethodsEx1 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

//            Teacher teacher1 = new Teacher("Zaur","Tregulov","Java",false);
//            entityManager.persist(teacher1);
//
//            teacher1.setSubject("SQL");
            Teacher teacher = entityManager.find(Teacher.class, 8);

            entityManager.remove(teacher);

            transaction.commit();

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
