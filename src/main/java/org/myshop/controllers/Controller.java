/*© 2025 MyShop. All rights reserved. Use of this application
constitutes acceptance of the Privacy Policy and Terms of Use.*/

package org.myshop.controllers;

import java.util.List;

public interface Controller<T> {
    T findById(long id);

    List<T> findAll();

    void save(T t);

    void deleteById(long id);
}
