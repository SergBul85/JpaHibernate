package org.hstn.jpql.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "universities")
@NamedQueries({
        @NamedQuery(name = "University.allUniversitiesLessOrEqualTo2",
                query = "select u from University u where size(u.students) <= 2 "),
        @NamedQuery(name = "University.studentsWithAvgGradeBetween",
                query = "select s from Student s where s.avgGrade between :from and :to")
})
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "founding_date")
    private Date foundingDate;

    @OneToMany(mappedBy = "university")
    private List<Student> students = new ArrayList<>();

    public University(String name, Date foundingDate) {
        this.name = name;
        this.foundingDate = foundingDate;
    }

    public University() {
    }

    public void addStudentToUniversity(Student student) {
        students.add(student);
        student.setUniversity(this);
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
