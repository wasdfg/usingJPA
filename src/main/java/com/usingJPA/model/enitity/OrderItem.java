package com.usingJPA.model.enitity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="ORDER_ITEM")
public class OrderItem {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name ="ITEM_ID")
    private Long itemid;

    @Column(name ="ORDER_ID")
    private Long orderId;

    private int orderPrice;

    private int count;

}
