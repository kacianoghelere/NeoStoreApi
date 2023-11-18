package com.neostore.api.repo;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.neostore.api.model.Supplier;

/**
 *
 * @author kaciano
 */
public class SupplierRepository {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("NeoStore");

    private EntityManager em;

    public SupplierRepository() {
        em = emf.createEntityManager();
    }

    public Supplier save(Supplier supplier) {
        em.getTransaction().begin();
        em.persist(supplier);
        em.getTransaction().commit();

        return supplier;
    }

    public Optional<Supplier> findById(Long id) {
        em.getTransaction().begin();

        Supplier supplier = em.find(Supplier.class, id);

        em.getTransaction().commit();

        return supplier != null ? Optional.of(supplier) : Optional.empty();
    }

    @SuppressWarnings("unchecked")
    public List<Supplier> findAll() {
        return em.createQuery("from Supplier").getResultList();
    }

    public Supplier update(Supplier supplier) {
        em.getTransaction().begin();

        supplier = em.merge(supplier);

        em.getTransaction().commit();

        return supplier;
    }

    public void deleteById(Long id) {
        em.getTransaction().begin();
        em.remove(em.find(Supplier.class, id));
        em.getTransaction().commit();
    }

    public void close() {
        emf.close();
    }
}
