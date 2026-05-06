package org.hstn.inheritance_mapping.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Driver extends Employee {

    @Column(name = "category")
    private Character category;

    @Column(name = "car_brend")
    private String carBrand;

    public Driver() {
    }

    public Driver(String name, Integer salary, Double experience, Character category, String carBrand) {
        super(name, salary, experience);
        this.category = category;
        this.carBrand = carBrand;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id='" + getId() + '\'' +
                "name='" + getName() + '\'' +
                "salary='" + getSalary() + '\'' +
                "experience='" + getExperience() + '\'' +
                "category=" + category +
                ", carBrand='" + carBrand + '\'' +
                '}';
    }
}
