package org.hstn.persistence_context.entity;


import jakarta.persistence.*;
import lombok.Data;
import org.hstn.relationships.many_to_many.entity.University;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "teachers")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "subject")
    private String subject;

    @Column(name = "is_professor")
    private boolean isProfessor;


    public Teacher(String name, String surname, String subject, boolean isProfessor) {
        this.name = name;
        this.surname = surname;
        this.subject = subject;
        this.isProfessor = isProfessor;
    }

    public Teacher() {
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", subject='" + subject + '\'' +
                ", isProfessor=" + isProfessor +
                '}';
    }
}
