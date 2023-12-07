package com.enigma.repository;
import com.enigma.entity.Order;

import java.util.List;

public interface OrderRepo {
    List<Order> getAll();

    void insert(Order order);

    Order getById(Integer id);
}
