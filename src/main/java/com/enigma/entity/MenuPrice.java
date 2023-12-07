package com.enigma.entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name="mst_menu_price")
public class MenuPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Menu menu;

    private Integer price;

    public MenuPrice(Integer id, Menu menu, Integer price) {
        this.id = id;
        this.menu = menu;
        this.price = price;
    }

    public MenuPrice(Menu menu, Integer price) {
        this.menu = menu;
        this.price = price;
    }

    public MenuPrice(Integer id) {
        this.id = id;
    }

    public MenuPrice() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "MenuPrice{" +
                "id=" + id +
                ", menu=" + menu +
                ", price=" + price +
                '}' + "\n";
    }
}
