///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
// */
//package com.neostore.api.service;
//
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import com.neostore.api.model.Supplier;
//import com.neostore.api.repo.SupplierRepository;
//
//public class SupplierServiceTest {
//
//    @Mock
//    private SupplierRepository repositoryMock;
//
//    @InjectMocks
//    private SupplierService supplierService;
//
//    @BeforeEach
//    public void setup() {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    public void testSaveSupplier() {
//        Supplier supplier = new Supplier();
//        supplier.setId(1L);
//        supplier.setName("Supplier 1");
//
//        when(repositoryMock.save(any(Supplier.class))).thenReturn(supplier);
//
//        Supplier savedSupplier = supplierService.save(supplier);
//
//        assertNotNull(savedSupplier);
//        assertEquals(supplier.getId(), savedSupplier.getId());
//        assertEquals(supplier.getName(), savedSupplier.getName());
//    }
//
//    @Test
//    public void testFindAllSuppliers() {
//        List<Supplier> suppliers = new ArrayList<>();
//        suppliers.add(new Supplier(1L, "Supplier 1"));
//        suppliers.add(new Supplier(2L, "Supplier 2"));
//
//        when(repositoryMock.findAll()).thenReturn(suppliers);
//
//        List<Supplier> foundSuppliers = supplierService.findAll();
//
//        assertNotNull(foundSuppliers);
//        assertEquals(suppliers.size(), foundSuppliers.size());
//        assertEquals(suppliers.get(0).getId(), foundSuppliers.get(0).getId());
//        assertEquals(suppliers.get(1).getName(), foundSuppliers.get(1).getName());
//    }
//
//    // Add more test methods for other functionalities like findById, deleteById, and update
//}