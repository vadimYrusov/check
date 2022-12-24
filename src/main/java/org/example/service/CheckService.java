package org.example.service;

import org.example.model.Check;
import org.example.model.Product;
import org.example.repository.CheckRepository;
import org.example.service.serviceInterface.CheckServiceInterface;

public class CheckService implements CheckServiceInterface {

    private final CheckRepository checkRepository;

    public CheckService(CheckRepository checkRepository) {
        this.checkRepository = checkRepository;
    }

    @Override
    public Check getCheck() {
        return null;
    }

    @Override
    public Check addProduct(Product product) {
        return null;
    }

    @Override
    public void delete(Long id) throws ClassNotFoundException {

    }
}
