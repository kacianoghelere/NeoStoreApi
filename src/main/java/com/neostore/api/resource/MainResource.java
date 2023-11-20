package com.neostore.api.resource;

import com.neostore.api.service.ApiStatusService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

/**
 *
 * @author kaciano
 */
@Path("/")
public class MainResource {

    @Inject
    ApiStatusService apiStatusService;
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getProductList() {
        return apiStatusService.getApiStatus();
    }
}
