/*© 2025 MyShop. All rights reserved. Use of this application
constitutes acceptance of the Privacy Policy and Terms of Use.*/

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
