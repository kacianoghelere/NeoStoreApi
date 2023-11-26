package com.neostore.api.model;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author kaciano
 */
public class SupplierTest {

    Validator validator;

    public SupplierTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testValidSupplier() {
        Supplier supplier = new Supplier();
        supplier.setName("Example Supplier");
        supplier.setEmail("example@example.com");
        supplier.setCnpj("15329745000176");

        Set<ConstraintViolation<Supplier>> constraints = validator.validate(supplier);

        assertTrue(constraints.isEmpty());
    }

    void validateConstraint(
            ConstraintViolation<Supplier> constraint,
            String field,
            String message
    ) {
        assertEquals(
                "com.neostore.api.model.Supplier",
                constraint.getLeafBean().getClass().getName());

        assertEquals(
                field,
                constraint.getPropertyPath().toString());

        assertEquals(
                message,
                constraint.getMessage());
    }

    @Test()
    public void testEmptySupplierCnpj() {
        Supplier supplier = new Supplier();
        supplier.setName("Example Supplier");
        supplier.setEmail("example@example.com");
        supplier.setCnpj("");

        Set<ConstraintViolation<Supplier>> constraints = validator.validate(supplier);

        assertFalse(constraints.isEmpty());

        ConstraintViolation<Supplier> constraint = constraints.iterator().next();

        validateConstraint(constraint, "cnpj", "CNPJ não pode ser nulo");
    }

    @Test()
    public void testInvalidSupplierCnpj() {
        Supplier supplier = new Supplier();
        supplier.setName("Example Supplier");
        supplier.setEmail("example@example.com");
        supplier.setCnpj("153297450001766");

        Set<ConstraintViolation<Supplier>> constraints = validator.validate(supplier);

        assertFalse(constraints.isEmpty());

        ConstraintViolation<Supplier> constraint = constraints.iterator().next();

        validateConstraint(constraint, "cnpj", "Informe um cnpj válido");
    }

    @Test()
    public void testEmptySupplierEmail() {
        Supplier supplier = new Supplier();
        supplier.setName("Example Supplier");
        supplier.setEmail("");
        supplier.setCnpj("37213813000170");

        Set<ConstraintViolation<Supplier>> constraints = validator.validate(supplier);

        assertFalse(constraints.isEmpty());

        ConstraintViolation<Supplier> constraint = constraints.iterator().next();

        validateConstraint(constraint, "email", "E-mail não pode ser nulo");
    }

    @Test()
    public void testInvalidSupplierEmail() {
        Supplier supplier = new Supplier();
        supplier.setName("Example Supplier");
        supplier.setEmail("exampleexample.com");
        supplier.setCnpj("37213813000170");

        Set<ConstraintViolation<Supplier>> constraints = validator.validate(supplier);

        assertFalse(constraints.isEmpty());

        ConstraintViolation<Supplier> constraint = constraints.iterator().next();

        validateConstraint(constraint, "email", "Informe um e-mail válido");
    }
}
