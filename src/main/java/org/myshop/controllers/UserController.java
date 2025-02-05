/*© 2025 MyShop. All rights reserved. Use of this application
constitutes acceptance of the Privacy Policy and Terms of Use.*/

package org.myshop.controllers;

import org.myshop.models.Order;
import org.myshop.models.User;
import org.myshop.service.ServiceContract;
import org.myshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController extends AbstractController<User> {
    @Autowired
    public UserController(UserService service) {
        super(service);
    }

    @PutMapping("/add/{id}")
    public void addOrder(@RequestBody Order order, @PathVariable long id) {
        ServiceContract<?> service = getService();

        if (service instanceof UserService userService) {
            userService.addOrder(order, id);
        }
    }

    @GetMapping("/authorize")
    public ResponseEntity<String> authorize(@RequestParam String email, @RequestParam String hashPassword) {
        ServiceContract<?> service = getService();

        if (service instanceof UserService userService) {
            userService.authorize(email, hashPassword);
        }

        return new ResponseEntity<>("You authorized successfully", HttpStatus.OK);
    }
}
