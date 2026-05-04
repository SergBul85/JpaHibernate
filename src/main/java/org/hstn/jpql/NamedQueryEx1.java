package org.hstn.jpql;

import jakarta.persistence.*;
import org.hstn.jpql.entity.Student;
import org.hstn.jpql.entity.University;

import java.util.List;

public class NamedQueryEx1 {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {

//            Query query = entityManager.createNamedQuery("University.allUniversitiesLessOrEqualTo2");
//            List<University> resultList = query.getResultList();
//            resultList.stream().forEach(System.out::println);

            Query query = entityManager.createNamedQuery("University.studentsWithAvgGradeBetween");
            query.setParameter("from", 9.1);
            query.setParameter("to", 9.8);
            List<Student> resultList = query.getResultList();
            resultList.forEach(System.out::println);


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
