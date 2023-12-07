package com.enigma.repository.Impl;

import com.enigma.config.Factory;
import com.enigma.entity.Customer;
import com.enigma.entity.Order;
import com.enigma.repository.OrderRepo;
import jakarta.persistence.EntityManager;

import java.util.List;

public class OrderRepoImpl implements OrderRepo {
    Factory factory = new Factory();

    EntityManager em = factory.openSession().createEntityManager();

    public OrderRepoImpl(Factory factory, EntityManager em) {
        this.factory = factory;
        this.em = em;
    }

    public OrderRepoImpl() {
    }

    @Override
    public List<Order> getAll() {
        return em.createQuery("select o from Order o", Order.class).getResultList();
    }

    @Override
    public void insert(Order order) {
            em.getTransaction().begin();
            em.persist(order);
            em.getTransaction().commit();
            System.out.println("Order Added");
    }

    @Override
    public Order getById(Integer id) {
        Order order = em.find(Order.class, id);
        if (order != null){
            return order;
        }
        System.out.println("Id not found");
        return null;
    }
}
