package org.hstn.advanced_mapping;

import jakarta.persistence.*;
import org.hstn.advanced_mapping.entity.Employee;
import org.hstn.advanced_mapping.entity.Friend;

import java.util.ArrayList;
import java.util.List;

public class ListMappingFriendEx {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
//            List<Friend> friendList = new ArrayList<>();
//
//            Friend f1 = new Friend("Name_1", "Surname_1", 11);
//            Friend f2 = new Friend("Name_2", "Surname_2", 22);
//            Friend f3 = new Friend("Name_3", "Surname_3", 33);
//            friendList.add(f1);
//            friendList.add(f2);
//            friendList.add(f3);
//
//            Employee employee1 = new Employee("Emp_name_1", 1111, 11.1, friendList);
//            entityManager.persist(employee1);
            Employee emp = entityManager.find(Employee.class, 2L);
            System.out.println(emp);
            System.out.println(emp.getFriends().size());

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
