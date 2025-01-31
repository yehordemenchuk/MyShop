package org.myshop.service;

import org.myshop.exceptions.ResourceNotFoundException;
import org.myshop.models.Category;
import org.myshop.models.Product;
import org.myshop.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService extends AbstractService<Category> {
    @Autowired
    public CategoryService(CategoryRepository repository) {
        super(repository);
    }

    public void addProduct(Product product, long categoryId) throws ResourceNotFoundException {
        existsOrThrow(categoryId);

        Category category = findById(categoryId);

        product.setCategory(category);

        category.getProducts().add(product);

        save(category);
    }
}
