package com.enigma.repository.Impl;

import com.enigma.config.Factory;
import com.enigma.entity.Customer;
import com.enigma.entity.Menu;
import com.enigma.repository.MenuRepo;
import jakarta.persistence.EntityManager;

import java.util.List;

public class MenuRepoImpl implements MenuRepo {

    Factory factory = new Factory();

    EntityManager em = factory.openSession().createEntityManager();
    @Override
    public List<Menu> getAll() {
        return em.createQuery("select m from Menu m", Menu.class).getResultList();
    }

    @Override
    public void insert(Menu menu) {
        em.getTransaction().begin();
        em.persist(menu);
        em.getTransaction().commit();
        System.out.println("Menu Added");
    }

    @Override
    public void update(Menu menu) {
        em.getTransaction().begin();
        if (getById(menu.getId()) != null){
            em.merge(menu);
            System.out.println("Update works");
        }else {
            System.out.println(menu.getId()+ "is not found");
        }
        em.getTransaction().commit();
    }

    @Override
    public void delete(Integer id) {
        Menu menu = em.find(Menu.class, id);
        if (menu != null){
            em.getTransaction().begin();
            em.remove(getById(id));
            em.getTransaction().commit();
        }else {
            System.out.println("ID not found");
        }
        System.out.println("Menu Deleted");
    }

    @Override
    public Menu getById(Integer id) {
        Menu menu = em.find(Menu.class, id);
        if (menu != null){
            return menu;
        }
        System.out.println("Id not found");
        return null;
    }
}
