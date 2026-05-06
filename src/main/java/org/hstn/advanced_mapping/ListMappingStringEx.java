package org.hstn.advanced_mapping;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.hstn.advanced_mapping.entity.Employee;
import org.hstn.advanced_mapping.entity.Friend;

import java.util.ArrayList;
import java.util.List;

public class ListMappingStringEx {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();

//            List<Friend> friends = new ArrayList<>();
//            friends.add("Roy_2");
//            friends.add("Kynglee_2");
//            friends.add("Eric_2");
//
//            Employee employee1 = new Employee("Rudolf", 2002, 2.2, friends);
//
//            entityManager.persist(employee1);

//            Employee employee = entityManager.find(Employee.class, 1L);
//            System.out.println(employee);
//            System.out.println("--------------------");
//            employee.getFriends().stream().forEach(System.out::println);

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
