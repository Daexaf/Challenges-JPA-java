package com.enigma.entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name="mst_menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String menu_name;

    @OneToMany(mappedBy = "menu")
    private List<MenuPrice> menu_price;

    public Menu(Integer id, String menu_name) {
        this.id = id;
        this.menu_name = menu_name;
    }

    public Menu(String menu_name) {
        this.menu_name = menu_name;
    }

    public Menu() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMenu_name() {
        return menu_name;
    }

    public void setMenu_name(String menu_name) {
        this.menu_name = menu_name;
    }

    public List<MenuPrice> getMenu_price() {
        return menu_price;
    }

    public void setMenu_price(List<MenuPrice> menu_price) {
        this.menu_price = menu_price;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", menu_name='" + menu_name + '\'' +
                '}' + "\n";
    }
}
