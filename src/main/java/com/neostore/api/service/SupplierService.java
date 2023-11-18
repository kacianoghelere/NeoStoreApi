package com.neostore.api.service;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import com.neostore.api.model.Supplier;
import com.neostore.api.repo.SupplierRepository;

/**
 *
 * @author kaciano
 */
public class SupplierService implements Service<Supplier> {

    private SupplierRepository repository;

    @Inject
    public SupplierService(SupplierRepository repository) {
        this.repository = repository;
    }

    public Supplier save(Supplier supplier) {
        return repository.save(supplier);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public Optional<Supplier> findById(Long id) {
        return repository.findById(id);
    }

    public List<Supplier> findAll() {
        return repository.findAll();
    }

    @Override
    public Supplier update(Supplier supplier) {
        return repository.update(supplier);
    }
}
