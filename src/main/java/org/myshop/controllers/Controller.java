package org.myshop.controllers;

import java.util.List;

public interface Controller<T> {
    T findById(long id);

    List<T> findAll();

    void save(T t);

    void deleteById(long id);
}
