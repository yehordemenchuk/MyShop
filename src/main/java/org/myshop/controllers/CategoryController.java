/*© 2025 MyShop. All rights reserved. Use of this application
constitutes acceptance of the Privacy Policy and Terms of Use.*/

package org.myshop.controllers;

import org.myshop.models.Category;
import org.myshop.models.Product;
import org.myshop.service.CategoryService;
import org.myshop.service.ServiceContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController extends AbstractController<Category> {
    @Autowired
    public CategoryController(CategoryService service) {
        super(service);
    }

    @PutMapping("/add/{id}")
    public void addProduct(@RequestBody Product product, @PathVariable long id) {
        ServiceContract<?> service = getService();

        if (service instanceof CategoryService categoryService) {
            categoryService.addProduct(product, id);
        }
    }
}
