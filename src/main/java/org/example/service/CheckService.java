package org.example.service;

import org.example.model.Check;

import org.example.model.Product;
import org.example.repository.CheckRepository;
import org.example.service.serviceInterface.CheckServiceInterface;

import java.util.List;

public class CheckService implements CheckServiceInterface {

    private final CheckRepository checkRepository;

    public CheckService(CheckRepository checkRepository) {
        this.checkRepository = checkRepository;
    }


    @Override
    public List<Check> findAll() {
        return checkRepository.findAll();
    }

    @Override
    public Check getCheckById(Long id) throws ClassNotFoundException {
        if (checkRepository.findById(id).isPresent()) {
            return checkRepository.findById(id).orElse(null);
        } else {
            throw new ClassNotFoundException("Check with this id not found");
        }
    }

    @Override
    public Check create(Check check) {
        return checkRepository.save(check);
    }

    @Override
    public Check update(Check check, Long id) throws ClassNotFoundException {
        Check existCheck = checkRepository.findById(id).orElse(null);
        if (existCheck != null) {
            existCheck.setSum(check.getSum());
            checkRepository.save(existCheck);
        } else {
            throw new ClassNotFoundException("Check with this id not found");
        }
        return existCheck;
    }

    @Override
    public void delete(Long id) throws ClassNotFoundException {
        if (checkRepository.findById(id).isPresent()) {
            checkRepository.deleteById(id);
        } else {
            throw new ClassNotFoundException("Check with this id not found");
        }
    }

    @Override
    public Check addProduct(Product product) {
        return null;
    }
}
