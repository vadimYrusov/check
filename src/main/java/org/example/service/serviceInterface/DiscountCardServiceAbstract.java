package org.example.service.serviceInterface;

import org.example.model.DiscountCard;
import org.example.model.Product;

import java.util.List;

public interface DiscountCardServiceAbstract {

    List<DiscountCard> findAll();

    DiscountCard getDiscountCardById(Long id) throws ClassNotFoundException;

    DiscountCard create (DiscountCard discountCard);

    DiscountCard update(DiscountCard discountCard, Long id) throws ClassNotFoundException;

    void delete (Long id) throws ClassNotFoundException;
}
