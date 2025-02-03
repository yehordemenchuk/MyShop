package org.myshop.controllers;

import org.myshop.models.Order;
import org.myshop.models.Product;
import org.myshop.service.OrderService;
import org.myshop.service.ServiceContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController extends AbstractController<Order> {
    @Autowired
    public OrderController(OrderService service) {
        super(service);
    }

    @PutMapping("/add/{id}")
    public void addProduct(@RequestBody Product product, @PathVariable long id) {
        ServiceContract<?> service = getService();

        if (service instanceof OrderService orderService) {
            orderService.addProduct(product, id);
        }
    }

    @GetMapping("/price/{id}")
    public BigDecimal totalPrice(@PathVariable long id) throws ClassCastException {
        ServiceContract<?> service = getService();

        if (service instanceof OrderService orderService) {
            return orderService.getTotalPrice(id);
        } else {
            throw new ClassCastException();
        }
    }
}
