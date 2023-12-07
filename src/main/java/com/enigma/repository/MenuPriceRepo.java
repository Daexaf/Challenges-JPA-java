package com.enigma.repository;
import com.enigma.entity.MenuPrice;

import java.util.List;

public interface MenuPriceRepo {
    List<MenuPrice> getAll();

    void insert(MenuPrice menuPrice);

    void update(MenuPrice menuPrice);

    void delete(Integer id);

    MenuPrice getById(Integer id);
}
