package com.usingJPA.JPA.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Team {
    @Id
    @Column(name ="TEAM_ID")
    private String id;
    private String name;

    @OneToMany(mappedBy = "team")
    private List<Members> members = new ArrayList<Members>();
}
