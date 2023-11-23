package com.neostore.api.exception.mapper;

import com.neostore.api.exception.InvalidDataException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

/**
 *
 * @author kaciano
 */
@Provider
public class InvalidDataMapper implements ExceptionMapper<InvalidDataException> {

    @Override
    public Response toResponse(InvalidDataException ex) {
        return Response.status(Response.Status.NOT_ACCEPTABLE)
                .entity(ex.getMessage())
                .type(MediaType.TEXT_PLAIN_TYPE)
                .build();
    }
}
