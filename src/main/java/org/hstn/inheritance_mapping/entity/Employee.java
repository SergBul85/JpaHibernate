package org.hstn.inheritance_mapping.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
//@Table(name = "employees")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@DiscriminatorColumn(name = "emp_type")
public abstract class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "salaty")
    private Integer salary;

    @Column(name = "experience")
    private Double experience;

    public Employee() {
    }

    public Employee(String name, Integer salary, Double experience) {
        this.name = name;
        this.salary = salary;
        this.experience = experience;
    }
}
