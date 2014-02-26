package com.programmeren4.turnahead.server.model;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class EMFService {
    private static final EntityManagerFactory emfInstance = Persistence.createEntityManagerFactory("transactions-optional"); // Wijst naar persistence.xml --> <persistence-unit>

    private EMFService() {
    }

    public static EntityManagerFactory get() {
        return emfInstance;
    }
}