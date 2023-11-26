package com.neostore.api.repo;

import com.neostore.api.model.Supplier;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author kaciano
 */
@RequestScoped
public class SupplierRepository {

    @PersistenceContext(unitName = "neo_store")
    protected EntityManager em;

    public SupplierRepository() {
        super();
    }

    public Supplier create(Supplier supplier) {
        em.persist(supplier);

        return supplier;
    }

    public Optional<Supplier> findById(Long id) {
        Supplier supplier = em.find(Supplier.class, id);

        return supplier != null ? Optional.of(supplier) : Optional.empty();
    }

    @SuppressWarnings("unchecked")
    public List<Supplier> findAll() {
        return em.createQuery("SELECT s FROM Supplier s", Supplier.class)
                .getResultList();
    }

    public Supplier update(Supplier supplier) {
        supplier = em.merge(supplier);

        return supplier;
    }

    public void deleteById(Long id) {
        Supplier supplier = em.find(Supplier.class, id);

        em.remove(supplier);
    }
}
