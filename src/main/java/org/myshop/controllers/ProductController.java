package org.myshop.controllers;

import org.myshop.models.Product;
import org.myshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController extends AbstractController<Product> {
    @Autowired
    public ProductController(ProductService service) {
        super(service);
    }
}
