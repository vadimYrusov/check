package org.example.service.serviceInterface;

import org.example.model.DiscountCard;

import java.util.List;

public interface DiscountCardServiceInterface {

    List<DiscountCard> findAll();

    DiscountCard getDiscountCardById(Long id) throws ClassNotFoundException;

    DiscountCard create (DiscountCard discountCard);

    DiscountCard update(DiscountCard discountCard, Long id) throws ClassNotFoundException;

    void delete (Long id) throws ClassNotFoundException;
}
