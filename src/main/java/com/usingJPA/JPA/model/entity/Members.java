package com.usingJPA.JPA.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@NoArgsConstructor
public class Members {
    @Id
    @Column(name="MEMBER_ID")
    private String id;
    private String username;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    public void setId(String id) {
        this.id = id;
    }

    public void setTeam(Team team) {
        if(this.team != null){ //기존 팀이 있다면
            this.team.getMembers().remove(this); //삭제해줌
        }
        this.team = team;
        team.getMembers().add(this);
    }

    public void setUsername(String username) {
        this.username = username;
    }
}