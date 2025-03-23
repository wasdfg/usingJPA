package com.usingJPA.test.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.Getter;

@Entity
@Getter
//@IdClass(ParentId.class)
public class Parent {

    @EmbeddedId
    private ParentId id;

    /*
    @Id
    @Column(name="PARENT_ID1")
    private String id1;

    @Id
    @Column(name="PARENT_ID2")
    private String id2;
    */
    private String name;

    public void setId(ParentId parentId) {
        this.id = parentId;
    }

    /*
    public void setId1(String id1){
        this.id1 = id1;
    }

    public void setId2(String id2){
        this.id2 = id2;
    }
    */

    public void setName(String name) {
        this.name = name;
    }
}
