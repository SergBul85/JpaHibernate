package org.hstn.relationships.many_to_many.entity;


import jakarta.persistence.*;
import lombok.Data;
import org.hstn.relationships.one_to_many.entity.Student;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "universities")
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "founding_date")
    private Date foundingDate;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "teacher_uni",
            joinColumns = @JoinColumn(name = "university_id"),
            inverseJoinColumns = @JoinColumn(name = "teacher_id")
    )
    private List<Teacher> teachers = new ArrayList<>();

    public University(String name, Date foundingDate) {
        this.name = name;
        this.foundingDate = foundingDate;
    }

    public University() {
    }

    public void addTeacherToUniversity(Teacher teacher) {
        teachers.add(teacher);
    }


    @Override
    public String toString() {
        return "University{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", foundingDate=" + foundingDate +
                '}';
    }
}
