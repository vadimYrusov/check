package org.example.repository;

import org.example.model.DiscountCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountCardRepository extends JpaRepository<DiscountCard, Long> {
}
