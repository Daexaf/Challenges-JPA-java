package com.enigma.repository.Impl;

import com.enigma.config.Factory;
import com.enigma.entity.Customer;
import com.enigma.entity.Table;
import com.enigma.repository.TableRepo;
import jakarta.persistence.EntityManager;

import java.util.List;

public class TableRepoImpl implements TableRepo {

    Factory factory = new Factory();

    EntityManager em = factory.openSession().createEntityManager();

    public TableRepoImpl(Factory factory, EntityManager em) {
        this.factory = factory;
        this.em = em;
    }

    public TableRepoImpl() {
    }

    @Override
    public List<Table> getAll() {
        return em.createQuery("select t from Table t", Table.class).getResultList();
    }

    @Override
    public void insert(Table table) {
        em.getTransaction().begin();
        em.persist(table);
        em.getTransaction().commit();
        System.out.println("Table Added");
    }

    @Override
    public void update(Table table) {
        em.getTransaction().begin();
        if (getById(table.getId()) != null){
            em.merge(table);
            System.out.println("Update works");
        }else {
            System.out.println(table.getId()+ "is not found");
        }
        em.getTransaction().commit();
    }

    @Override
    public void delete(Integer id) {
        Table table = em.find(Table.class, id);
        if (table != null){
            em.getTransaction().begin();
            em.remove(getById(id));
            em.getTransaction().commit();
        }else {
            System.out.println("ID not found");
        }
        System.out.println("Table Deleted");
    }

    @Override
    public Table getById(Integer id) {
        Table table = em.find(Table.class, id);
        if (table != null){
            return table;
        }
        System.out.println("Id not found");
        return null;
    }
}
