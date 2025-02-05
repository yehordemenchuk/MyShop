/*© 2025 MyShop. All rights reserved. Use of this application
constitutes acceptance of the Privacy Policy and Terms of Use.*/

package org.myshop.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Product {
    @Id
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String description;

    @NonNull
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    @JsonBackReference("product-category-reference")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "order_id")
    @JsonBackReference("product-order-reference")
    private Order order;
}
