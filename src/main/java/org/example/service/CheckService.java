package org.example.service;

import org.example.model.Check;

import org.example.model.DiscountCard;
import org.example.model.Product;
import org.example.repository.CheckRepository;
import org.example.repository.DiscountCardRepository;
import org.example.repository.ProductRepository;
import org.example.service.serviceInterface.CheckServiceInterface;

import java.util.List;

public class CheckService implements CheckServiceInterface {

    private final CheckRepository checkRepository;

    private final ProductRepository productRepository;

    private final DiscountCardRepository discountCardRepository;

    public CheckService(CheckRepository checkRepository, ProductRepository productRepository, DiscountCardRepository discountCardRepository) {
        this.checkRepository = checkRepository;
        this.productRepository = productRepository;
        this.discountCardRepository = discountCardRepository;
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
    public void addProduct(Product product, Long id) throws ClassNotFoundException {
        if (checkRepository.findById(id).isPresent()) {
            checkRepository.findById(id).get().getProducts().add(product);
        } else {
            throw new ClassNotFoundException("Check with this id not found");
        }
    }

    @Override
    public void addCard(DiscountCard card, Long id) throws ClassNotFoundException {
        if (checkRepository.findById(id).isPresent()) {
            DiscountCard existCard = checkRepository.findById(id).get().getDiscountCard();
            existCard.setCardNumber(card.getCardNumber());
            existCard.setId(card.getId());
        } else {
            throw new ClassNotFoundException("Check with this id not found");
        }
    }

    @Override
    public void deleteProduct(Long checkId , Long productId) throws ClassNotFoundException {
        if (checkRepository.findById(checkId).isPresent() && productRepository.findById(productId).isPresent()) {
            checkRepository.findById(checkId).get().getProducts().remove(productRepository.findById(productId).get());
        } else {
            throw new ClassNotFoundException("Check with this id not found");
        }
    }

    @Override
    public void deleteCard(Long checkId, Long cardId) throws ClassNotFoundException {
        if (checkRepository.findById(checkId).isPresent() && discountCardRepository.findById(cardId).isPresent()) {
            checkRepository.findById(checkId).get().setDiscountCard(new DiscountCard());
        } else {
            throw new ClassNotFoundException("Check with this id not found");
        }
    }

    @Override
    public Long getSum(Long id) throws ClassNotFoundException {
        if (checkRepository.findById(id).isPresent()) {
            long sum = 0;
            for (Product product : checkRepository.findById(id).get().getProducts()) {
                sum = sum + product.getPrice();
            }
            return sum;
        } else {
            throw new ClassNotFoundException("Check with this id not found");
        }
    }
}
