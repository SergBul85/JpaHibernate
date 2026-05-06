package org.hstn.relationships.one_to_many;

import jakarta.persistence.*;
import org.hstn.relationships.one_to_many.entity.Student;
import org.hstn.relationships.one_to_many.entity.University;

import java.sql.Date;
import java.util.List;


public class NPlusOneProblem {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();

//            University university1 = new University("Harvard", Date.valueOf("1636-10-19"));
//            University university2 = new University("MIT", Date.valueOf("1636-03-03"));
//            University university3 = new University("Stanford", Date.valueOf("1636-02-02"));
//
//            Student s1 = new Student("Chanel", "King", 9.1);
//            Student s2 = new Student("Leo", "Farrel", 9.2);
//            Student s3 = new Student("Julea", "Dean", 9.3);
//
//            university1.addStudentToUniversity(s1);
//            university2.addStudentToUniversity(s2);
//            university3.addStudentToUniversity(s3);
//
//            em.persist(university1);
//            em.persist(university2);
//            em.persist(university3);

            // N+1
            Query query = em.createQuery("select s from Student s " +
                    "join fetch s.university", Student.class);
            List<Student> students = query.getResultList();
            for(Student student : students){
                System.out.println(student.getName()+", "+student.getUniversity().getName());
            }

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
                emf.close();
            }
        }

    }
}
