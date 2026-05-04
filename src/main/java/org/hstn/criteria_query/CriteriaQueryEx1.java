package org.hstn.criteria_query;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hstn.criteria_query.entity.Student;

import java.util.List;

public class CriteriaQueryEx1 {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            // 1 Creation of Criteria Builder
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

            // 2 Creation of CriteriaQuery
            CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);

            //3 Root creation
            Root<Student> root = criteriaQuery.from(Student.class);// from Student s

            //4 Adding root to Criteria Query
            criteriaQuery.select(root); // Select s from Student s

            //5 Query creation
            TypedQuery<Student> query = entityManager.createQuery(criteriaQuery);

            List<Student> students = query.getResultList();
            students.forEach(System.out::println);

            //
            Query query100 = entityManager.createQuery("select s from Student s");
            List<Student> students100 = query100.getResultList();

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
