package org.hstn.criteria_query.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
//@Entity
//@Table(name = "universities")
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "founding_date")
    private Date foundingDate;

    @OneToMany(mappedBy = "university", fetch = FetchType.LAZY)
    private List<Student> students = new ArrayList<>();

    public University(String name, Date foundingDate) {
        this.name = name;
        this.foundingDate = foundingDate;
    }

    public University() {
    }

    public void addStudentToUniversity(Student student) {
        students.add(student);
//        student.setUniversity(this);
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
