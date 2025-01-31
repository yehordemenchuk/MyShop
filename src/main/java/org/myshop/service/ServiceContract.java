package org.myshop.service;

import org.myshop.exceptions.ResourceNotFoundException;

import java.util.List;

public interface ServiceContract<T> {
    void save(T t);

    T findById(long id) throws ResourceNotFoundException;

    List<T> findAll();

    void deleteById(long id) throws ResourceNotFoundException;
}
