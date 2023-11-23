package com.neostore.api.resource;

import com.neostore.api.exception.InvalidDataException;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

import com.neostore.api.exception.ResourceNotFoundException;
import com.neostore.api.model.Supplier;
import com.neostore.api.service.SupplierService;

/**
 *
 * @author kaciano
 */
@Path("/suppliers")
public class SupplierResource {

    @Inject
    private SupplierService supplierService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Supplier> getSupplierList() {
        return supplierService.findAll();
    }

    @GET
    @Path("{supplierId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Supplier getSupplier(@PathParam(value = "supplierId") Long supplierId) {
        return supplierService.findById(supplierId)
                .orElseThrow(() -> new ResourceNotFoundException("supplierId " + supplierId + " not found"));
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Supplier createSupplier(@Valid Supplier supplier) {
        try {
            supplierService.save(supplier);

            return supplier;
        } catch (Exception e) {
            throw new InvalidDataException(e.getMessage(), e);
        }
    }

    @PUT
    @Path("{supplierId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Supplier updateSupplier(
            @PathParam(value = "supplierId") Long supplierId,
            @Valid Supplier newSupplier
    ) {
        return supplierService.findById(supplierId).map(oldSupplier -> {
            oldSupplier.setName(newSupplier.getName());
            oldSupplier.setDescription(newSupplier.getDescription());
            oldSupplier.setEmail(newSupplier.getEmail());
            oldSupplier.setCnpj(newSupplier.getCnpj());

            return supplierService.update(oldSupplier);
        }).orElseThrow(() -> new ResourceNotFoundException("supplierId " + supplierId + " not found"));
    }

    @DELETE
    @Path("{supplierId}")
    @Produces(MediaType.TEXT_PLAIN)
    @Transactional
    public String deleteSupplier(@PathParam(value = "supplierId") Long supplierId) {
        return supplierService.findById(supplierId).map(p -> {
            supplierService.deleteById(supplierId);

            return "Supplier deleted";
        }).orElseThrow(() -> new ResourceNotFoundException("supplierId " + supplierId + " not found"));
    }
}
