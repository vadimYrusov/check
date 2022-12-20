package org.example.service.serviceInterface;

import org.example.model.Check;
import org.example.model.DiscountCard;
import org.example.model.Product;

import java.util.List;

public interface CheckServiceInterface {

    Check getCheck();

    Check addProduct (Product product);

    void delete (Long id) throws ClassNotFoundException;
}
