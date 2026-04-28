package org.hstn.relationships.one_to_one;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.hstn.relationships.one_to_one.entity.Passport;
import org.hstn.relationships.one_to_one.entity.Student;

public class OneToOneUni {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            //      region PERSIST
            //            Student student1 = new Student("Isaak", "Sharp", 6.5);
            //            Passport passport1 = new Passport("isaak.sharp@gmail.com", 175, "brown");
            //            student1.setPassport(passport1);
            //
            //            entityManager.persist(passport1);
            //            entityManager.persist(student1);
            //  endregion

            //region FIND

//            Student student = entityManager.find(Student.class, 400);
//            System.out.println(student);
//            System.out.println(student.getPassport());

            //endregion

            //region REMOVE

            Student student = entityManager.find(Student.class, 2);
            entityManager.remove(student);

            //endregion



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
