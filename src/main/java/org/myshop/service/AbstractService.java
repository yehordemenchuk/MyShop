package org.myshop.service;

import lombok.Getter;
import org.myshop.exceptions.ResourceNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Getter
public abstract class AbstractService<T> implements ServiceContract<T> {
    private final JpaRepository<T, Long> repository;
    private static final String NOT_FOUND_MESSAGE = "Resource not found";
    
    protected AbstractService(JpaRepository<T, Long> repository) {
        this.repository = repository;
    }
    
    protected void existsOrThrow(long id) throws ResourceNotFoundException {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException(NOT_FOUND_MESSAGE);
        }
    }

    @Override
    public void save(T t) {
        repository.save(t);
    }

    @Override
    public T findById(long id) throws ResourceNotFoundException {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(NOT_FOUND_MESSAGE));
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(long id) throws ResourceNotFoundException {
        existsOrThrow(id);

        repository.deleteById(id);
    }
}
