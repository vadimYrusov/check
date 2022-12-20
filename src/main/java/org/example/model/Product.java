package org.example.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    private Long id;

    private String title;

    private Long price;

//    @ManyToMany(mappedBy = "products")
//    private List<Check> checks;
}
