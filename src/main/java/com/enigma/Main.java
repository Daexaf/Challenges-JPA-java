package com.enigma;

import com.enigma.config.Factory;
import com.enigma.entity.*;
import com.enigma.repository.Impl.*;
import com.enigma.util.TransType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.sql.Date;

public class Main {
    public static void main(String[] args) {

        Factory factory = new Factory();
        EntityManagerFactory emf = factory.openSession();
        EntityManager em = emf.createEntityManager();

        //untuk customer
        CustomerRepoImpl cust = new CustomerRepoImpl();
//        cust.insert(new Customer("Adam", "0873596845",false));
//        cust.update(new Customer(2, "susan", "0812345", false));
//        cust.delete(4);
//        System.out.println(cust.getById(1));
//        System.out.println(cust.getAll());

//        untuk menu
        MenuRepoImpl menus = new MenuRepoImpl();
//        menus.insert(new Menu("mie ayam"));
//        menus.update(new Menu(2, "Bakso"));
//        menus.delete(3);
//        System.out.println(menus.getById(2));
//        System.out.println(menus.getAll());

//        untuk menu_price
        MenuRepoImpl menuRepo = new MenuRepoImpl();
//        MenuPrice bakso = new MenuPrice();
//        bakso.setPrice(10000);
//        bakso.setMenu(menuRepo.getById(2));
//        MenuPriceRepoImpl menuPriceRepo = new MenuPriceRepoImpl();
//        menuPriceRepo.insert(bakso);


//        untuk Meja
        TableRepoImpl tables = new TableRepoImpl();
//        tables.insert(new Table("3"));
//        tables.update(new Table(3,"2,5"));
//        tables.delete(3);
//        System.out.println(tables.getById(2));
//        System.out.println(tables.getAll());

//        untuk order
        OrderRepoImpl orders = new OrderRepoImpl();
//        Order order1 = new orders.insert(new Order(Date.valueOf("2023-02-20"), new Customer(1),2, TransType.EI));
//        orders.insert(new Order(Date.valueOf("2023-02-20"), new Customer(1),2, TransType.EI));
//        System.out.println(orders.getById(1));
//        System.out.println(orders.getAll());

//        untuk order detail
        OrderDetailRepoImpl ordersD = new OrderDetailRepoImpl();
//        ordersD.insert(new OrderDetail(new Order(1),new MenuPrice(2), 3));
//        System.out.println(ordersD.getById(2));
//        System.out.println(orders.getAll());


    }
}