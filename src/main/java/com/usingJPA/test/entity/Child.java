package com.usingJPA.test.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

@Entity
@Getter
public class Child {
    @Id
    private String id;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "PARENT_ID1",referencedColumnName = "PARENT_ID1"),
            @JoinColumn(name = "PARENT_ID2",referencedColumnName = "PARENT_ID2")
    })
    private Parent parent;
}
