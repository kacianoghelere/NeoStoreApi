package com.neostore.api.service;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author kaciano
 */
public interface Service<T> {
    T save(T object);
 
    T update(T object);
 
    void deleteById(Long id);
 
    Optional<T> findById(Long id);
 
    List<T> findAll();
}
