package org.hstn.jpql;

import jakarta.persistence.*;
import org.hstn.jpql.entity.Student;


import java.util.List;

public class JPQLEx2 {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();

            //region ALL STUDENTS WITH "a" in name
//            Query query = entityManager.createQuery("SELECT s from Student as s " +
//                    "where s.name like '%a%' ");
//            List<Student> students = query.getResultList();
//            students.forEach(System.out::println);
            //endregion ALL STUDENTS WITH "a" in name

            //region ALL STUDENTS WITH "a" or "A" in name
//            Query query = entityManager.createQuery("SELECT s from Student as s " +
//                    "where lower(s.name) like '%a%' ");
//            List<Student> students = query.getResultList();
//            students.forEach(System.out::println);
            //endregion ALL STUDENTS WITH "a" or "A" in name

            //region ALL STUDENTS WITHOUT AVG_GRADE
//            Query query = entityManager.createQuery("Select s from Student s " +
//                    " where s.avgGrade is null ");
//            List<Student> students = query.getResultList();
//            students.forEach(System.out::println);
            //endregion ALL STUDENTS WITHOUT AVG_GRADE

            //region ALL STUDENTS with 'l' in name and avg > 8.5
//            Query query = entityManager.createQuery("Select s from Student s " +
//                    " where s.avgGrade > 8.5 and s.name like '%l%'  ");
//            List<Student> students = query.getResultList();
//            students.forEach(System.out::println);
            //endregion ALL STUDENTS with 'l' in name and avg > 8.5

            //region ALL STUDENTS names
//            Query query = entityManager.createQuery("Select s.name from Student s ");
//            List<String> names = query.getResultList();
//            names.forEach(System.out::println);
            //endregion ALL STUDENTS names

            //region ALL STUDENTS names and avg
//            Query query = entityManager.createQuery("Select s.name, s.avgGrade from Student s ");
//            List<Object[]> resultList = query.getResultList();
//            for (Object[] obj : resultList) {
//                System.out.println(obj[0] + " : " + obj[1]);
//            }
            //endregion ALL STUDENTS names and avg

            //region MAX AVG
//            Query query = entityManager.createQuery("Select max(s.avgGrade) from Student s ");
//            double singleResult = (Double) query.getSingleResult();
//            System.out.println(singleResult);
            //endregion MAX AVG

            //region AVG AVG
//            Query query = entityManager.createQuery("Select avg (s.avgGrade) from Student s ");
//            double singleResult = (Double) query.getSingleResult();
//            System.out.println(singleResult);
            //endregion AVG AVG

            transaction.commit();
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
