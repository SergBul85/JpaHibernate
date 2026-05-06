package org.hstn.inheritance_mapping;

import jakarta.persistence.*;
import org.hstn.inheritance_mapping.entity.Driver;
import org.hstn.inheritance_mapping.entity.Employee;
import org.hstn.inheritance_mapping.entity.Teacher;

import java.util.List;

public class InheritanceMappingEx {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();

//            Teacher teacher = new Teacher("Alesandro", 2500, 8.0, "CS", true);
//            Driver driver = new Driver("Peter", 2300, 15.0, 'B', "BMW");

//            Teacher teacher = new Teacher("Rio", 2503, 8.3, "BIO", false);
//            Driver driver = new Driver("Michael", 2304, 15.4, 'D', "FORD");
//
//            entityManager.persist(teacher);
//            entityManager.persist(driver);

//            Query query = entityManager.createQuery("select emp from Employee emp");
//            List<Employee> resultList = query.getResultList();
//            resultList.forEach(System.out::println);

            Query query = entityManager.createQuery("select dr from Driver dr");
            List<Driver> resultList = query.getResultList();
            resultList.forEach(System.out::println);

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
