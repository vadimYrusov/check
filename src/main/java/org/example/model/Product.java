package org.example.model;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private Long id;

    private String title;

    private Long price;

}
