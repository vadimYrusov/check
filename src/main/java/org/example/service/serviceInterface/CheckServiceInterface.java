package org.example.service.serviceInterface;

import org.example.model.Check;
import org.example.model.DiscountCard;
import org.example.model.Product;

import java.util.List;

public interface CheckServiceInterface {

    List<Check> findAll();

    Check getCheckById(Long id) throws ClassNotFoundException;

    Check create (Check check);

    Check update(Check check, Long id) throws ClassNotFoundException;

    void delete (Long id) throws ClassNotFoundException;

    void addProduct (Product product, Long id) throws ClassNotFoundException;

    void addCard (DiscountCard card, Long id) throws ClassNotFoundException;
}
