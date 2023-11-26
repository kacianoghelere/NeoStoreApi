package com.neostore.api.exception.mapper;

import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import java.util.Set;

/**
 *
 * @author kaciano
 */
@Provider
public class ConstraintViolationMapper implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(final ConstraintViolationException exception) {
        Set<ConstraintViolation<?>> constraintViolations = exception.getConstraintViolations();

        JsonObjectBuilder jsonObject = Json.createObjectBuilder()
                .add("title", "Validation Errors");

        JsonArrayBuilder jsonArray = Json.createArrayBuilder();

        for (ConstraintViolation<?> constraint : constraintViolations) {
            String className = constraint.getLeafBean().toString().split("@")[0];

            String message = constraint.getMessage();

//            String propertyPath = constraint.getPropertyPath().toString().split("\\.")[2];
            JsonObject jsonError = Json.createObjectBuilder()
                    .add("class", className)
                    //                    .add("field", propertyPath)
                    .add("violationMessage", message)
                    .build();

            jsonArray.add(jsonError);
        }

        JsonObject errorJsonEntity = jsonObject
                .add("errors", jsonArray.build())
                .build();

        return Response
                .status(Response.Status.BAD_REQUEST)
                .entity(errorJsonEntity)
                .build();
    }
}
