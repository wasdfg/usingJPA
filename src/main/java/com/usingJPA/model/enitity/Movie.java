package com.usingJPA.model.enitity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;

@Entity
@Getter
@DiscriminatorValue("M")
public class Movie extends Item{

    private String director;

    private String actor;

    public void setActor(String actor) {
        this.actor = actor;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "director='" + director + '\'' +
                ", actor='" + actor + '\'' +
                '}';
    }
}
