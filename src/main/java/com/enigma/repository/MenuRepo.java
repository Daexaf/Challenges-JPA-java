package com.enigma.repository;
import com.enigma.entity.Menu;

import java.util.List;

public interface MenuRepo {
    List<Menu> getAll();

    void insert(Menu menu);

    void update(Menu menu);

    void delete(Integer id);

    Menu getById(Integer id);
}
