package com.usingJPA.model.enitity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;

@Entity
@Getter
@DiscriminatorValue("A")
public class Album extends Item{

    private  String artist;

    private String etc;

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setEtc(String etc){
        this.etc = etc;
    }

    @Override
    public String toString() {
        return "Album{" +
                "artist='" + artist + '\'' +
                ", etc='" + etc + '\'' +
                '}';
    }
}
