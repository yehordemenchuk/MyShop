package org.myshop.service;

import org.myshop.models.Product;
import org.myshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends AbstractService<Product> {
    @Autowired
    public ProductService(ProductRepository repository) {
        super(repository);
    }
}
