package com.enigma.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@jakarta.persistence.Table(name = "mst_table")
public class Table {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String table_name;

    public Table(Integer id, String table_name) {
        this.id = id;
        this.table_name = table_name;
    }

    public Table(String table_name) {
        this.table_name = table_name;
    }

    public Table() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTable_name() {
        return table_name;
    }

    public void setTable_name(String table_name) {
        this.table_name = table_name;
    }

    @Override
    public String toString() {
        return "Table{" +
                "id=" + id +
                ", table_name='" + table_name + '\'' +
                '}';
    }
}
