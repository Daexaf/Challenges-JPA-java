package com.enigma.entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name="mst_customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String customer_name;

    private String mobile_phone;

    @OneToMany(mappedBy = "customer")
    private List<Order> order;

    private boolean is_member;

    public Customer(Integer id, String customer_name, String mobile_phone, boolean is_member) {
        this.id = id;
        this.customer_name = customer_name;
        this.mobile_phone = mobile_phone;
        this.is_member = is_member;
    }

    public Customer(String customer_name, String mobile_phone, boolean is_member) {
        this.customer_name = customer_name;
        this.mobile_phone = mobile_phone;
        this.is_member = is_member;
    }

    public Customer(Integer id) {
        this.id = id;
    }

    public Customer() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getMobile_phone() {
        return mobile_phone;
    }

    public void setMobile_phone(String mobile_phone) {
        this.mobile_phone = mobile_phone;
    }

    public boolean isIs_member() {
        return is_member;
    }

    public void setIs_member(boolean is_member) {
        this.is_member = is_member;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", customer_name='" + customer_name + '\'' +
                ", mobile_phone='" + mobile_phone + '\'' +
                ", is_member=" + is_member +
                '}' + "\n";
    }
}
