package org.hstn.relationships.one_to_many;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.hstn.relationships.one_to_many.entity.University;

public class LoadingTypesEx {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {

            //region FIND

//            System.out.println("UNIVERSITY INFO");
//            University university = entityManager.find(University.class, 1);
//            System.out.println(university);
//
//            university.getStudents().size();
//
//            entityManager.close();
//
//            System.out.println("STUDENTS INFO");
//            university.getStudents().forEach(System.out::println);

            //endregion

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
