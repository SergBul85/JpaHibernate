package org.hstn.jpql;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.hstn.jpql.entity.Student;

public class FlushEx2 {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();

            System.out.println("First saelect");
            Student student1 = entityManager.find(Student.class, 3);
            Student student2 = entityManager.find(Student.class, 3);

            System.out.println("Second saelect");
            Student student3 = entityManager.createQuery("select s from Student s " +
                    "where s.id = 3", Student.class).getSingleResult();


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
