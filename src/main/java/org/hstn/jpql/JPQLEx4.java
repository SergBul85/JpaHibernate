package org.hstn.jpql;

import jakarta.persistence.*;
import org.hstn.jpql.entity.University;


import java.util.List;

public class JPQLEx4 {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();

            //region UNIVERSITIES WITHOUT STUDENTS
//            Query query =  entityManager.createQuery("select u from University u " +
//                    "where u.students is empty ");
//            List<University> universityList = query.getResultList();
//            universityList.forEach(System.out::println);
            //endregion UNIVERSITIES WITHOUT STUDENTS

            //region UNIVERSITIES 1 STUDENT
//            Query query = entityManager.createQuery("select u from University u " +
//                    "where size (u.students) = ?1 ");
//            query.setParameter(1, 1);
//            List<University> universityList = query.getResultList();
//            universityList.forEach(System.out::println);
            //endregion UNIVERSITIES 1 STUDENT

            //region  UNIVERSITIES SORT BY COUNT STUDENTS DESC
//            Query query = entityManager.createQuery("select u from University u " +
//                    " order by size(u.students) desc ");
//            List<University> universityList = query.getResultList();
//            universityList.forEach(System.out::println);
            //endregion  UNIVERSITIES SORT BY COUNT STUDENTS DESC

            //region  CROSS JOIN
//            Query query = entityManager.createQuery("select u,s from University u, Student  s  ");
//            List<Object[]> results = query.getResultList();
//
//            for (Object[] result : results) {
//                System.out.println(result[0] + " --> " + result[1]);
//            }

            //endregion CROSS JOIN

            //region  CROSS JOIN
//            Query query = entityManager.createQuery("select u,s from University u " +
//                    "join u.students s");
//            List<Object[]> results = query.getResultList();
//
//            for (Object[] result : results) {
//                System.out.println(result[0] + "\t\t --> " + result[1]);
//            }
            //endregion CROSS JOIN

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
