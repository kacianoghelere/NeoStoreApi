package com.neostore.api.resource;

import com.neostore.api.service.HelloWorldService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

/**
 *
 * @author kaciano
 */
@Path("/greeting")
public class GreetingResource {

    @Inject
    HelloWorldService helloWorldService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getGreetingMessage() {
        return helloWorldService.getHelloWorld("my friend");
    }

    @GET
    @Path("{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getGreetingMessageForName(
            @PathParam(value = "name") String name
    ) {
        return helloWorldService.getHelloWorld(name);
    }
}
