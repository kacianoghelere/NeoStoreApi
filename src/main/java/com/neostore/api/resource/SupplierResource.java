package com.neostore.api.resource;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

import com.neostore.api.exception.ResourceNotFoundException;
import com.neostore.api.model.Supplier;
import com.neostore.api.service.SupplierService;

/**
 *
 * @author kaciano
 */
@Path("suppliers")
public class SupplierResource {

    @Inject
    private SupplierService supplierService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Supplier> getSupplierList(
            @NotBlank(message = "Consumerkey is required")
            @QueryParam(value = "consumerKey") String consumerKey
    ) {
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
