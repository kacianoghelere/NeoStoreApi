package com.neostore.api.validation;

import com.neostore.api.model.Supplier;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 *
 * @author kaciano
 */
@ApplicationScoped
public class SupplierValidator {

    public Optional<List<String>> validate(Supplier supplier) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

        Validator validator = factory.getValidator();

        Set<ConstraintViolation<Supplier>> violations = validator.validate(supplier);

        if (violations.isEmpty()) {
            return Optional.empty();
        }

        List<String> errors = new ArrayList<String>();

        for (ConstraintViolation<Supplier> violation : violations) {
            errors.add(violation.getMessage());
        }

        return Optional.of(errors);
    }
}
