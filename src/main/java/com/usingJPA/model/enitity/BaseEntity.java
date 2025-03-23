package com.usingJPA.model.enitity;

import jakarta.persistence.MappedSuperclass;
import java.util.Date;
import lombok.Getter;

@MappedSuperclass
@Getter
public class BaseEntity {

    private Date createdDate;

    private Date lsatModifiedDate;

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public void setLsatModifiedDate(Date lsatModifiedDate) {
        this.lsatModifiedDate = lsatModifiedDate;
    }
}
