package org.hstn.relationships.one_to_many;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.hstn.relationships.one_to_many.entity.Student;
import org.hstn.relationships.one_to_many.entity.University;

import java.sql.Date;

public class OneToManyBi {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            //region PERSIST_1
//            University university = new University("MIT", Date.valueOf("1960-01-01"));
//            Student student1 = new Student("Name_1", "Surname_1", 1.1);
//            Student student2 = new Student("Name_2", "Surname_2", 2.2);
//
//            university.addStudentToUniversity(student1);
//            university.addStudentToUniversity(student2);
//
//            entityManager.persist(university);
            //endregion

            //region REPSIST_2

//            Student student3 = new Student("Name_3", "Surname_3", 3.3);
//            Student student4 = new Student("Name_4", "Surname_4", 4.4);
//            University university = new University("Oksford", Date.valueOf("1333-03-03"));

//            university.addStudentToUniversity(student3);
//            university.addStudentToUniversity(student4);
//            entityManager.persist(student4);

            //endregion

            //region FIND

//            University university = entityManager.find(University.class, 3);
//            System.out.println(university);
//            System.out.println(university.getStudents());

//            Student student = entityManager.find(Student.class, 3);
//            System.out.println(student);
//            System.out.println(student.getUniversity());

            //endregion

            //region REMOVE
//            Student student = entityManager.find(Student.class, 4);
//            entityManager.remove(student);

            //endregion

            //region ORDER_BY

//            University university = new University("DNU", Date.valueOf("2000-02-02"));
//            Student s1 = new Student("Name_1","Surname_1",111.1);
//            Student s2 = new Student("Name_2","Surname_2",22.2);
//            Student s3 = new Student("Name_3","Surname_3",22.2);
//            Student s4 = new Student("Name_4","Surname_4",4.4);
//
//            university.addStudentToUniversity(s1);
//            university.addStudentToUniversity(s2);
//            university.addStudentToUniversity(s3);
//            university.addStudentToUniversity(s4);
//
//            entityManager.persist(university);

            University university = entityManager.find(University.class, 1);
            System.out.println(university);
            System.out.println();
            university.getStudents().stream().forEach(System.out::println);

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
