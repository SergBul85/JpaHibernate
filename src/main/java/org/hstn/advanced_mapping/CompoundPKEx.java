package org.hstn.advanced_mapping;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hstn.advanced_mapping.entity.Book;
import org.hstn.advanced_mapping.id.BookId;

public class CompoundPKEx {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

//        Book book1 = new Book("Author_1", "Book1", 1001, 1.1);
//        Book book2 = new Book("Author_1", "Book2", 2002, 2.2);
//        Book book3 = new Book("Author_3", "Book3", 3003, 3.3);

//        em.persist(book1);
//        em.persist(book2);
//        em.persist(book3);

//        Book book = em.find(Book.class, new BookId("Author_1","Book2"));
//        System.out.println(book);

        em.getTransaction().commit();

    }
}
