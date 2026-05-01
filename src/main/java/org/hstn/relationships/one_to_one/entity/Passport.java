package org.hstn.relationships.one_to_one.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hstn.relationships.one_to_one.EyeColor;

//@Data
//@Entity
//@Table(name = "passports")
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "height")
    private int height;

    @Enumerated(EnumType.STRING)
    @Column(name = "eye_color")
    private EyeColor eyeColor;

    @OneToOne(mappedBy = "passport", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Student student;

    public Passport(String email, int height, EyeColor eyeColor) {
        this.email = email;
        this.height = height;
        this.eyeColor = eyeColor;
    }

    public Passport() {
    }

    @Override
    public String toString() {
        return "Passport{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", height=" + height +
                ", eyeColor='" + eyeColor + '\'' +
                '}';
    }
}
