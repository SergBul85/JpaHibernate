package org.hstn.relationships.one_to_one;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.hstn.relationships.one_to_one.entity.Passport;
import org.hstn.relationships.one_to_one.entity.Student;

public class OneToOneBi {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            //region PERSIST

//            Student student = new Student("Frankie", "Perrie", 2.2);
//            Passport passport = new Passport("fr.perri@gmail.com", 212, "brown_2");
//
//            passport.setStudent(student);
//            student.setPassport(passport);
//
//            entityManager.persist(passport);

            //endregion

            //region FIND
//            Passport passport = entityManager.find(Passport.class, 2);
//            System.out.println(passport);
//            System.out.println(passport.getStudent());
            //endregion

            //region REMOVE

//            Student student = entityManager.find(Student.class, 2);
//            entityManager.remove(student);
//            Passport passport = entityManager.find(Passport.class, 3);
//            passport.getStudent().setPassport(null);
//            entityManager.remove(passport);

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
