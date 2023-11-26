package com.neostore.api.service;

import com.neostore.api.model.Supplier;
import com.neostore.api.repo.SupplierRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author kaciano
 */
@RequestScoped
public class SupplierService implements CrudService<Supplier> {

    @Inject
    private SupplierRepository repository;

    @Override
    public Supplier create(Supplier supplier) {
        return repository.create(supplier);
//        try {
//            return repository.create(supplier);
//        } catch (Exception e) {
//            throw new WebApplicationException("teste de erro", Response.Status.FORBIDDEN);
//        }
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
