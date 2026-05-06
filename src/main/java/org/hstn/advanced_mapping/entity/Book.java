package org.hstn.advanced_mapping.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hstn.advanced_mapping.id.BookId;

import java.sql.Date;

@Setter
@Getter
@Entity
@Table(name = "books")
@IdClass(BookId.class)
public class Book {

    @Id
    @Column(name = "author")
    private String author;

    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "publication_year")
    private Integer publicationYear;

    @Column(name = "rating")
    private Double rating;

    public Book() {
    }

    public Book(String author, String name, Integer publicationYear, Double rating) {
        this.author = author;
        this.name = name;
        this.publicationYear = publicationYear;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Book{" +
                ", author='" + author + '\'' +
                ", name='" + name + '\'' +
                ", publicationYear=" + publicationYear +
                ", rating=" + rating +
                '}';
    }
}
