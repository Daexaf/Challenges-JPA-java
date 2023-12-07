package com.enigma.repository.Impl;

import com.enigma.config.Factory;
import com.enigma.entity.Customer;
import com.enigma.entity.OrderDetail;
import com.enigma.repository.OrderDetailRepo;
import jakarta.persistence.EntityManager;

import java.util.List;

public class OrderDetailRepoImpl implements OrderDetailRepo {
    Factory factory = new Factory();

    EntityManager em = factory.openSession().createEntityManager();

    public OrderDetailRepoImpl(Factory factory, EntityManager em) {
        this.factory = factory;
        this.em = em;
    }

    public OrderDetailRepoImpl() {
    }

    @Override
    public List<OrderDetail> getAll() {
        return em.createQuery("select d from OrderDetail d", OrderDetail.class).getResultList();
    }

    @Override
    public void insert(OrderDetail orderD) {
        em.getTransaction().begin();
        em.persist(orderD);
        em.getTransaction().commit();
        System.out.println("Order Detail Added");
    }

    @Override
    public OrderDetail getById(Integer id) {
        OrderDetail order = em.find(OrderDetail.class, id);
        if (order != null){
            return order;
        }
        System.out.println("Id not found");
        return null;
    }
}
