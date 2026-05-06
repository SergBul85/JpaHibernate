package org.hstn.advanced_mapping.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
//@Entity
//@Table(name = "Employees")
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

//    @Embedded // OPTIONAL
//    @AttributeOverrides({
//            @AttributeOverride(name = "country", column = @Column(name = "emp_country")),
//            @AttributeOverride(name = "city", column = @Column(name = "emp_city")),
//            @AttributeOverride(name = "street", column = @Column(name = "emp_street")),
//            @AttributeOverride(name = "house", column = @Column(name = "emp_house"))
//    }
//    )
//    private Address address;

    //    @ElementCollection()
//    @CollectionTable(name = "emp_friends", joinColumns = @JoinColumn(name = "emp_id"))
//    @Column(name = "friend_name")
    @ElementCollection
    @CollectionTable(name = "emp_friends", joinColumns = @JoinColumn(name = "emp_id"))
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "emp_surname")),
            @AttributeOverride(name = "surname", column = @Column(name = "emp_name")),
            @AttributeOverride(name = "age", column = @Column(name = "emp_age"))
    })
    List<Friend> friends = new ArrayList<>();


    public Employee() {
    }

    public Employee(String name, Integer salary, Double experience, List<Friend> friends) {
        this.name = name;
        this.salary = salary;
        this.experience = experience;
        this.friends = friends;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", experience=" + experience +
                ", friends=" + friends +
                '}';
    }
}
