package org.hstn.criteria_query;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.hstn.criteria_query.entity.Student;

import java.util.List;

public class CriteriaQueryEx2 {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
//            //JOQL: select s.name from Student s;
//
//            // 1 Creation of Criteria Builder
//            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//
//            // 2 Creation of CriteriaQuery
//            CriteriaQuery<String> criteriaQuery = criteriaBuilder.createQuery(String.class);
//
//            //3 Root creation
//            Root<Student> root = criteriaQuery.from(Student.class);// from Student s
//
//            //4 Adding root to Criteria Query
//            criteriaQuery.select(root.get("name")); // Select s.name from Student s
//
//            //5 Query creation
//            TypedQuery<String> query = entityManager.createQuery(criteriaQuery);
//
//            List<String> students = query.getResultList();
//            students.forEach(System.out::println);

            //JOQL: select s from Student s where avgGrade >=7.5;

            // 1 Creation of Criteria Builder
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

            // 2 Creation of CriteriaQuery
            CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);

            //3 Root creation
            Root<Student> root = criteriaQuery.from(Student.class);// from Student s

            //3.1 Condition creation
            Predicate predicate = criteriaBuilder.greaterThanOrEqualTo(root.get("avgGrade"), 7.5);
            //3.2 Adding condition to criteria query
            criteriaQuery.where(predicate);

            //4 Adding root to Criteria Query
            criteriaQuery.select(root); // Select s.name from Student s where avgGrade >= 7.5

            //5 Query creation
            TypedQuery<Student> query = entityManager.createQuery(criteriaQuery);

            List<Student> students = query.getResultList();
            students.forEach(System.out::println);


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
