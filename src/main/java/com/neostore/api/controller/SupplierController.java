package com.neostore.api.controller;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import lombok.extern.slf4j.Slf4j;

import com.neostore.api.exception.ResourceNotFoundException;
import com.neostore.api.model.Supplier;
import com.neostore.api.service.SupplierService;

/**
 *
 * @author kaciano
 */
@Slf4j
@Path("suppliers")
public class SupplierController {

    private SupplierService supplierService;

    @Inject
    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Supplier> getSupplierList(
            @NotBlank(message = "Consumerkey is required")
            @QueryParam(value = "consumerKey") String consumerKey
    ) {
        log.info("Consumer: {}", consumerKey);

        return supplierService.findAll();
    }

    @GET
    @Path("{supplierId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Supplier getSupplier(@PathParam(value = "supplierId") Long supplierId) {
        return supplierService.findById(supplierId).orElseThrow(() -> new ResourceNotFoundException("supplierId " + supplierId + " not found"));
    }

    @POST
    public String createSupplier(@Valid Supplier supplier) {
        supplierService.save(supplier);

        return "Supplier added";
    }

    @PUT
    @Path("{supplierId}")
    public String updateSupplier(@PathParam(value = "supplierId") Long supplierId, @Valid Supplier newSupplier) {
        return supplierService.findById(supplierId).map(oldSupplier -> {
            oldSupplier.setName(newSupplier.getName());
            oldSupplier.setDescription(newSupplier.getDescription());

            supplierService.update(oldSupplier);

            return "Supplier updated";
        }).orElseThrow(() -> new ResourceNotFoundException("supplierId " + supplierId + " not found"));
    }

    @DELETE
    @Path("{supplierId}")
    public String deleteSupplier(@PathParam(value = "supplierId") Long supplierId) {
        return supplierService.findById(supplierId).map(p -> {
            supplierService.deleteById(supplierId);

            return "Supplier deleted";
        }).orElseThrow(() -> new ResourceNotFoundException("supplierId " + supplierId + " not found"));
    }
}
