package com.neostore.api.repo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author kaciano
 */
public abstract class Repository<T> {

    protected EntityManagerFactory emf = Persistence.createEntityManagerFactory("NeoStore");

    protected EntityManager em;

    public Repository() {
        em = emf.createEntityManager();
    }

    public void close() {
        emf.close();
    }
}
