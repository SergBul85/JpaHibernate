package org.hstn.relationships.one_to_one.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "passports")
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "height")
    private int height;

    @Column(name = "eye_color")
    private String eyeColor;

    public Passport(String email, int height, String eyeColor) {
        this.email = email;
        this.height = height;
        this.eyeColor = eyeColor;
    }

    public Passport() {
    }

}
