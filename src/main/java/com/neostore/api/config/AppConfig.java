package com.neostore.api.config;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

import com.neostore.api.controller.SupplierController;
import com.neostore.api.repo.SupplierRepository;
import com.neostore.api.service.SupplierService;

/**
 *
 * @author kaciano
 */
public class AppConfig extends ResourceConfig {

    public AppConfig() {
        register(SupplierController.class);
        register(new AbstractBinder() {
            @Override
            protected void configure() {
                bind(SupplierService.class).to(SupplierService.class);
                bind(SupplierRepository.class).to(SupplierRepository.class);
            }
        });

        property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
    }
}
