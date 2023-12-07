package com.enigma.repository;
import com.enigma.entity.OrderDetail;

import java.util.List;

public interface OrderDetailRepo {
    List<OrderDetail> getAll();

    void insert(OrderDetail order);

    OrderDetail getById(Integer id);
}
