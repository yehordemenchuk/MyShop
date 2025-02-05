/*© 2025 MyShop. All rights reserved. Use of this application
constitutes acceptance of the Privacy Policy and Terms of Use.*/

package org.myshop.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@Setter @Getter
public class Category {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private Long id;

    @NonNull
    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("product-category-reference")
    private List<Product> products;
}
