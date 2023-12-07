package com.enigma.config;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Factory {
    static String PERSISTENCE_NAME = "Challenges-JPA";

    public static EntityManagerFactory openSession(){
        return Persistence.createEntityManagerFactory(PERSISTENCE_NAME);
    }
}
