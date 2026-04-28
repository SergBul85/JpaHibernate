package org.hstn.relationships.one_to_one;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.hstn.relationships.one_to_one.entity.Passport;
import org.hstn.relationships.one_to_one.entity.Student;

public class EnumEx {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();


        try {
            transaction.begin();
//            Student student = new Student("Eric", "Scott", 7.1);
//            Passport passport = new Passport("eric.scott@gmail.com", 111, EyeColor.GREEN);
//            student.setPassport(passport);
//            entityManager.persist(student);

            Student student = entityManager.find(Student.class, 1);
            System.out.println(student.getPassport());


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
