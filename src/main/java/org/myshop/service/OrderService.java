package org.myshop.service;

import org.myshop.exceptions.ResourceNotFoundException;
import org.myshop.models.Order;
import org.myshop.models.Product;
import org.myshop.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class OrderService extends AbstractService<Order> {
    @Autowired
    public OrderService(OrderRepository repository) {
        super(repository);
    }

    public void addProduct(Product product, long orderId) throws ResourceNotFoundException {
        existsOrThrow(orderId);

        Order order = findById(orderId);

        product.setOrder(order);

        order.getProducts().add(product);

        save(order);
    }

    public BigDecimal getTotalPrice(long orderId) throws ResourceNotFoundException {
        existsOrThrow(orderId);

        Order order = findById(orderId);

        AtomicReference<BigDecimal> totalPrice = new AtomicReference<>(BigDecimal.ZERO);

        order.getProducts().forEach(product -> totalPrice.updateAndGet(
                current -> current.add(product.getPrice())
        ));

        return totalPrice.get();
    }
}
