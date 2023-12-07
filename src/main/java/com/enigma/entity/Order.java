package com.enigma.entity;

import com.enigma.util.TransType;
import jakarta.persistence.*;
import jakarta.persistence.Table;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name="trx_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date transaction_date;

    @ManyToOne
    private Customer customer;

    private Integer table_id;

    @OneToMany(mappedBy = "order")
    private List<OrderDetail> order_detail;

    @Enumerated(EnumType.STRING)
    private TransType transaction_type;

    public Order() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Order(Integer id, Date transaction_date, Customer customer, Integer table_id, List<OrderDetail> order_detail, TransType transaction_type) {
        this.id = id;
        this.transaction_date = transaction_date;
        this.customer = customer;
        this.table_id = table_id;
        this.order_detail = order_detail;
        this.transaction_type = transaction_type;
    }

    public Order(Date transaction_date, Customer customer, Integer table_id, List<OrderDetail> order_detail, TransType transaction_type) {
        this.transaction_date = transaction_date;
        this.customer = customer;
        this.table_id = table_id;
        this.order_detail = order_detail;
        this.transaction_type = transaction_type;
    }

    public Order(Date transaction_date, Customer customer, Integer table_id, TransType transaction_type) {
        this.transaction_date = transaction_date;
        this.customer = customer;
        this.table_id = table_id;
        this.transaction_type = transaction_type;
    }

    public Order(Integer id) {
        this.id = id;
    }

    public Date getTransaction_date() {
        return transaction_date;
    }

    public void setTransaction_date(Date transaction_date) {
        this.transaction_date = transaction_date;
    }

    public Integer getTable_id() {
        return table_id;
    }

    public void setTable_id(Integer table_id) {
        this.table_id = table_id;
    }


    public TransType getTransaction_type() {
        return transaction_type;
    }

    public void setTransaction_type(TransType transaction_type) {
        this.transaction_type = transaction_type;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderDetail> getOrder_detail() {
        return order_detail;
    }

    public void setOrder_detail(List<OrderDetail> order_detail) {
        this.order_detail = order_detail;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", transaction_date=" + transaction_date +
                ", customer=" + customer +
                ", table_id=" + table_id +
                ", order_detail=" + order_detail +
                ", transaction_type=" + transaction_type +
                '}' + "\n";
    }
}
