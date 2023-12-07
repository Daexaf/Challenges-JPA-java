package com.enigma.entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;

@Entity
@Table(name="trx_order_detail")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Order order;

    @ManyToOne
    private MenuPrice menuPrice;

    private Integer qty;


    public OrderDetail(Integer id, Order order, MenuPrice menuPrice, Integer qty) {
        this.id = id;
        this.order = order;
        this.menuPrice = menuPrice;
        this.qty = qty;
    }

    public OrderDetail(Order order, MenuPrice menuPrice, Integer qty) {
        this.order = order;
        this.menuPrice = menuPrice;
        this.qty = qty;
    }

    public OrderDetail() {
    }

    public OrderDetail(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MenuPrice getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(MenuPrice menuPrice) {
        this.menuPrice = menuPrice;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }


    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "id=" + id +
//                ", order=" + order +
                ", menuPrice=" + menuPrice +
                ", qty=" + qty +
                '}';
    }
}
