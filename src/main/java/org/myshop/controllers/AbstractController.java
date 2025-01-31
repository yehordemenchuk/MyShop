package org.myshop.controllers;

import lombok.Getter;
import org.myshop.service.ServiceContract;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Getter
public abstract class AbstractController<T> implements Controller<T> {
    private final ServiceContract<T> service;

    protected AbstractController(ServiceContract<T> service) {
        this.service = service;
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public void deleteById(@PathVariable long id) {
        service.deleteById(id);
    }

    @GetMapping("/{id}")
    @Override
    public T findById(@PathVariable long id) {
        return service.findById(id);
    }

    @PostMapping("/save")
    @Override
    public void save(@RequestBody T t) {
        service.save(t);
    }

    @GetMapping("/all")
    @Override
    public List<T> findAll() {
        return service.findAll();
    }
}
