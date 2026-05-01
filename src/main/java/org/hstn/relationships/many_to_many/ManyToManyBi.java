package org.hstn.relationships.many_to_many;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.hstn.relationships.many_to_many.entity.Teacher;
import org.hstn.relationships.many_to_many.entity.University;

import java.sql.Date;

public class ManyToManyBi {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            //region PERSIST
//            University university = new University("Harvard", Date.valueOf("2010-01-01"));
//            Teacher t1 = new Teacher("Alesandro", "Lazano", "CS", true);
//            Teacher t2 = new Teacher("Rio", "Berger", "Biology", false);
//            Teacher t3 = new Teacher("Landry", "Shelton", "Math", true);
//
//            university.addTeacherToUniversity(t1);
//            university.addTeacherToUniversity(t2);
//            university.addTeacherToUniversity(t3);
//
//            entityManager.persist(university);

            //endregion

            //region PERSIST
//            Teacher teacher = new Teacher("Vera","Valter","Gepgraphy",true);
//            University university1 = new University("MIT",Date.valueOf("2020-01-01"));
//            University university2 = new University("Cambridge",Date.valueOf("2020-02-02"));
//            University university3 = new University("Oxford",Date.valueOf("2020-01-01"));
//
//            teacher.addUniversityToTeacher(university1);
//            teacher.addUniversityToTeacher(university2);
//            teacher.addUniversityToTeacher(university3);
//
//            entityManager.persist(teacher);
            //endregion

            //region FIND

//            University university = entityManager.find(University.class, 1);
//
//            System.out.println(university);
//            university.getTeachers().stream().forEach(System.out::println);

//            Teacher teacher = entityManager.find(Teacher.class, 4);
//            System.out.println(teacher);
//            teacher.getUniversities().stream().forEach(System.out::println);

            //endregion

            //region REMOVE
//            Teacher teacher = entityManager.find(Teacher.class, 8);
//            University university = entityManager.find(University.class, 1);
//            teacher.addUniversityToTeacher(university);
//            entityManager.persist(teacher);

//            Teacher teacher = entityManager.find(Teacher.class, 8);
//            entityManager.remove(teacher);

//            University university = entityManager.find(University.class, 5);
//            entityManager.remove(university);

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
