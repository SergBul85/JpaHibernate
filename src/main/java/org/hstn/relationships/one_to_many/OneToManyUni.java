package org.hstn.relationships.one_to_many;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.hstn.relationships.one_to_many.entity.Student;
import org.hstn.relationships.one_to_many.entity.University;

import java.sql.Date;

public class OneToManyUni {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            //region PERSIST
//            University university = new University("Harvard", Date.valueOf("1636-10-28"));
//            Student student1 = new Student("Roy", "Harper", 7.1);
//            Student student2 = new Student("Kingly", "Boyer", 7.2);
//
//            university.addStudentToUniversity(student1);
//            university.addStudentToUniversity(student2);
//
//            entityManager.persist(university);
            //endregion

            //            region FIND
//            University university = entityManager.find(University.class, 1);
//            System.out.println(university);
//            System.out.println(university.getStudents());
            //endregion FIND

            //region DELETE

            University university = entityManager.find(University.class, 1);
//            university.addStudentToUniversity(new Student("Name_3", "Surname_3", 3.03));
//            university.addStudentToUniversity(new Student("Name_4", "Surname_4", 4.04));

//            Student student1 = entityManager.find(Student.class, 3);
//            Student student2 = entityManager.find(Student.class, 4);
//            entityManager.remove(student1);

            University university2 = entityManager.find(University.class, 1);
            entityManager.remove(university);


            //endregion DELETE
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
