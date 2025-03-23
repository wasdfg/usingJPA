package com.usingJPA.model.enitity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;

@Entity
@Getter
@DiscriminatorValue("B")
public class Book extends Item{
    private String author;

    private String isbn;

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Book{}";
    }
}
