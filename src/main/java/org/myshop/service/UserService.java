/*© 2025 MyShop. All rights reserved. Use of this application
constitutes acceptance of the Privacy Policy and Terms of Use.*/

package org.myshop.service;

import org.myshop.exceptions.ResourceNotFoundException;
import org.myshop.exceptions.UnauthorizedAccessException;
import org.myshop.models.Order;
import org.myshop.models.User;
import org.myshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends AbstractService<User> {
    @Autowired
    public UserService(UserRepository repository) {
        super(repository);
    }

    public void addOrder(Order order, long userId) throws ResourceNotFoundException {
        existsOrThrow(userId);

        User user = findById(userId);

        order.setUser(user);

        user.getOrders().add(order);

        save(user);
    }

    public void authorize(String email, String hashPassword) throws UnauthorizedAccessException {
        if (findAll().stream().noneMatch(u -> u.getEmail().equals(email)
                && u.getHashPassword().equals(hashPassword))) {

            throw new UnauthorizedAccessException("Email or password isn`t match");
        }
    }
}
