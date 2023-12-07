package com.enigma.repository.Impl;
import com.enigma.config.Factory;
import com.enigma.entity.Customer;
import com.enigma.repository.CustomerRepo;
import jakarta.persistence.EntityManager;

import java.util.List;

public class CustomerRepoImpl implements CustomerRepo {
    Factory factory = new Factory();

    EntityManager em = factory.openSession().createEntityManager();

    public CustomerRepoImpl(Factory factory, EntityManager em) {
        this.factory = factory;
        this.em = em;
    }

    public CustomerRepoImpl() {
    }

    @Override
    public List<Customer> getAll() {
        return em.createQuery("select c from Customer c", Customer.class).getResultList();
    }

    @Override
    public void insert(Customer customer) {
        em.getTransaction().begin();
        em.persist(customer);
        em.getTransaction().commit();
        System.out.println("Customer Added");
    }

    @Override
    public void update(Customer customer) {
        em.getTransaction().begin();
        if (getById(customer.getId()) != null){
            em.merge(customer);
            System.out.println("Update works");
        }else {
            System.out.println(customer.getId()+ "is not found");
        }
        em.getTransaction().commit();
    }

    @Override
    public void delete(Integer id) {
        Customer customer = em.find(Customer.class, id);
        if (customer != null){
            em.getTransaction().begin();
            em.remove(getById(id));
            em.getTransaction().commit();
        }else {
            System.out.println("ID not found");
        }
        System.out.println("Customer Deleted");
    }

    @Override
    public Customer getById(Integer id) {
        Customer customer = em.find(Customer.class, id);
        if (customer != null){
            return customer;
        }
        System.out.println("Id not found");
        return null;
    }
}
