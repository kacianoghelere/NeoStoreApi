package com.neostore.api.util;

import com.neostore.api.dto.SupplierDto;
import com.neostore.api.model.Supplier;
import jakarta.enterprise.context.ApplicationScoped;

/**
 *
 * @author kaciano
 */
@ApplicationScoped
public class SupplierUtil {

    public Supplier buildFromDto(SupplierDto data) {
        Supplier supplier = new Supplier();

        supplier.setName(data.getName());
        supplier.setDescription(data.getDescription());
        supplier.setEmail(data.getEmail());
        supplier.setCnpj(data.getCnpj());

        return supplier;
    }
}
