package com.enigma.repository;

import com.enigma.entity.Table;

import java.util.List;

public interface TableRepo {

    List<Table> getAll();

    void insert(Table table);

    void update(Table table);

    void delete(Integer id);

    Table getById(Integer id);
}
