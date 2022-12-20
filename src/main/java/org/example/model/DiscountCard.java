package org.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DiscountCard {

    @Id
    private Long id;

    private Long cardNumber;

}
