package com.neostore.api.repo;

import java.util.List;
import java.util.Optional;
import jakarta.enterprise.context.RequestScoped;

import com.neostore.api.model.Supplier;

/**
 *
 * @author kaciano
 */
@RequestScoped
public class SupplierRepository extends Repository {
    public SupplierRepository() {
        super();
    }

    public Supplier save(Supplier supplier) {
        this.em.getTransaction().begin();
        this.em.persist(supplier);
        this.em.getTransaction().commit();

        return supplier;
    }

    public Optional<Supplier> findById(Long id) {
        this.em.getTransaction().begin();

        Supplier supplier = this.em.find(Supplier.class, id);

        this.em.getTransaction().commit();

        return supplier != null ? Optional.of(supplier) : Optional.empty();
    }

    @SuppressWarnings("unchecked")
    public List<Supplier> findAll() {
        return this.em.createQuery("from Supplier").getResultList();
    }

    public Supplier update(Supplier supplier) {
        this.em.getTransaction().begin();

        supplier = this.em.merge(supplier);

        this.em.getTransaction().commit();

        return supplier;
    }

    public void deleteById(Long id) {
        this.em.getTransaction().begin();
        this.em.remove(this.em.find(Supplier.class, id));
        this.em.getTransaction().commit();
    }
}
