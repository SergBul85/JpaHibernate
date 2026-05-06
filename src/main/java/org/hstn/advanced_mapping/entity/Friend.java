package org.hstn.advanced_mapping.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Friend {
    private String name;
    private String surname;
    private int age;

    public Friend() {
    }

    public Friend(String surname, String name, int age) {
        this.surname = surname;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Friend{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }
}
