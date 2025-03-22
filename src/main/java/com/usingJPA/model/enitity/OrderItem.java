package com.usingJPA.model.enitity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Getter
@Table(name="ORDER_ITEM")
public class OrderItem {
    @Id
    @GeneratedValue
    @Column(name="ORDER_ITEM_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name ="ITEM_ID")
    private Item item;

    @ManyToOne
    @JoinColumn(name ="ORDER_ID")
    private Orders orders;

    private int orderPrice;

    private int count;

    public void setId(Long id) {
        this.id = id;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public void setOrderPrice(int orderPrice) {
        this.orderPrice = orderPrice;
    }
}
