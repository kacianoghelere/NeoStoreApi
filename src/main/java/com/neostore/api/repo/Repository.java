package com.neostore.api.repo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 *
 * @author kaciano
 */
public abstract class Repository<T> {

    protected EntityManagerFactory emf = Persistence.createEntityManagerFactory("neo_store");

    protected EntityManager em;

    public Repository() {
        em = emf.createEntityManager();
    }

    public void close() {
        emf.close();
    }
}
