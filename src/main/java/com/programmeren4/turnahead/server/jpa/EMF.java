package com.programmeren4.turnahead.server.jpa;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class EMF {
    private static final EntityManagerFactory emfInstance =
        Persistence.createEntityManagerFactory("turnPU"); // Wijst naar persistence.xml --> <persistence-unit>

    private EMF() {}

    public static EntityManagerFactory get() {
        return emfInstance;
    }
}