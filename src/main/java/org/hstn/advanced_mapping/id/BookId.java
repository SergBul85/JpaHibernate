package org.hstn.advanced_mapping.id;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class BookId implements Serializable {

    private String author;

    private String name;

    public BookId() {
    }

    public BookId(String author, String name) {
        this.author = author;
        this.name = name;
    }


}
