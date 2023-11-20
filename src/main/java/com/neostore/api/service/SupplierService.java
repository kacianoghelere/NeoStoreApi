package com.neostore.api.service;

import java.util.List;
import java.util.Optional;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import com.neostore.api.model.Supplier;
import com.neostore.api.repo.SupplierRepository;

/**
 *
 * @author kaciano
 */
@RequestScoped
public class SupplierService implements Service<Supplier> {

    @Inject
    private SupplierRepository repository;

    @Override
    public Supplier save(Supplier supplier) {
        return repository.save(supplier);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Supplier> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Supplier> findAll() {
        return repository.findAll();
    }

    @Override
    public Supplier update(Supplier supplier) {
        return repository.update(supplier);
    }
}
