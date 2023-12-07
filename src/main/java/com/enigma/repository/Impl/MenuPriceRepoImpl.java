package com.enigma.repository.Impl;

import com.enigma.config.Factory;
import com.enigma.entity.Customer;
import com.enigma.entity.MenuPrice;
import com.enigma.repository.MenuPriceRepo;
import jakarta.persistence.EntityManager;

import java.util.List;

public class MenuPriceRepoImpl implements MenuPriceRepo {

    Factory factory = new Factory();

    EntityManager em = factory.openSession().createEntityManager();

    public MenuPriceRepoImpl(Factory factory, EntityManager em) {
        this.factory = factory;
        this.em = em;
    }

    public MenuPriceRepoImpl() {
    }



    @Override
    public List<MenuPrice> getAll() {
        return em.createQuery("select p from MenuPrice p", MenuPrice.class).getResultList();
    }

    @Override
    public void insert(MenuPrice menuPrice) {
        em.getTransaction().begin();
        em.persist(menuPrice);
        em.getTransaction().commit();
        System.out.println("menu price Added");
    }

    @Override
    public void update(MenuPrice menuPrice) {
        em.getTransaction().begin();
        if (getById(menuPrice.getId()) != null){
            em.merge(menuPrice);
            System.out.println("Update works");
        }else {
            System.out.println(menuPrice.getId()+ "is not found");
        }
        em.getTransaction().commit();
    }

    @Override
    public void delete(Integer id) {
        MenuPrice menuPrice = em.find(MenuPrice.class, id);
        if (menuPrice != null){
            em.getTransaction().begin();
            em.remove(getById(id));
            em.getTransaction().commit();
        }else {
            System.out.println("ID not found");
        }
        System.out.println("menu price Deleted");
    }

    @Override
    public MenuPrice getById(Integer id) {
        MenuPrice menuPrice = em.find(MenuPrice.class, id);
        if (menuPrice != null){
            return menuPrice;
        }
        System.out.println("Id not found");
        return null;
    }
}
