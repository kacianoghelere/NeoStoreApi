package com.neostore.api.service;

import com.neostore.api.dto.SupplierDto;
import com.neostore.api.model.Supplier;
import com.neostore.api.repo.SupplierRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import java.util.ArrayList;
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

    public Supplier buildFromDto(SupplierDto data) {
        Supplier supplier = new Supplier();

        supplier.setName(data.getName());
        supplier.setDescription(data.getDescription());
        supplier.setEmail(data.getEmail());
        supplier.setCnpj(data.getCnpj());

        return supplier;
    }

    @Override
    public Supplier create(Supplier supplier) {
        return repository.create(supplier);
    }

    public List<Supplier> batchCreate(List<SupplierDto> suppliersData) {
        List<Supplier> suppliers = new ArrayList<Supplier>();

        suppliersData.forEach((data) -> {
            suppliers.add(create(buildFromDto(data)));
        });

        return suppliers;
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
