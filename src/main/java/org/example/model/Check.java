package org.example.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Check {

    @Id
    private Long id;

    private Long sum;

//    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "check_product",
//            joinColumns = {@JoinColumn(name = "check_id", referencedColumnName = "id")},
//            inverseJoinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "id")}
//    )
//    private List<Product> products;
//
//    private DiscountCard discountCard;
}
