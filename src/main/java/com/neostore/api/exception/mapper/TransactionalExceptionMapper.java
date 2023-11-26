package com.neostore.api.exception.mapper;

import jakarta.transaction.TransactionalException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

/**
 *
 * @author kaciano
 */
@Provider
public class TransactionalExceptionMapper implements ExceptionMapper<TransactionalException> {

    @Override
    public Response toResponse(TransactionalException ex) {
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(ex.getMessage())
                .type(MediaType.TEXT_PLAIN_TYPE)
                .build();
    }
}
