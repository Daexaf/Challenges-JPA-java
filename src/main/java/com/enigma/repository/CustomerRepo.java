package com.enigma.repository;
import com.enigma.entity.Customer;

import java.util.List;

public interface CustomerRepo {
    List<Customer> getAll();

    void insert(Customer customer);

    void update(Customer customer);

    void delete(Integer id);

    Customer getById(Integer id);
}
