package org.hstn.advanced_mapping.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "salary")
    private Integer salary;

    @Column(name = "experience")
    private Double experience;

    @Embedded // OPTIONAL
    @AttributeOverrides({
            @AttributeOverride(name = "country", column = @Column(name = "emp_country")),
            @AttributeOverride(name = "city", column = @Column(name = "emp_city")),
            @AttributeOverride(name = "street", column = @Column(name = "emp_street")),
            @AttributeOverride(name = "house", column = @Column(name = "emp_house"))
    }
    )
    private Address address;

    public Employee() {
    }

    public Employee(String name, Integer salary, Double experience, Address address) {
        this.name = name;
        this.salary = salary;
        this.experience = experience;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", experience=" + experience +
                ", address=" + address +
                '}';
    }
}
