package com.neostore.api.exception.mapper;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

/**
 *
 * @author kaciano
 */
@Provider
public class ServerExceptionMapper implements ExceptionMapper<WebApplicationException> {

    @Override
    public Response toResponse(WebApplicationException exception) {
        String message = exception.getMessage();

        Response response = exception.getResponse();

        Status status = response.getStatusInfo().toEnum();

        return Response.status(status)
                .entity(status + ": " + message)
                .type(MediaType.TEXT_PLAIN)
                .build();
    }
}
