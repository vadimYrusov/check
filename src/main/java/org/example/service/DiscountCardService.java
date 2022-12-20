package org.example.service;

import org.example.model.DiscountCard;
import org.example.model.Product;
import org.example.repository.DiscountCardRepository;
import org.example.service.serviceInterface.DiscountCardServiceAbstract;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountCardService implements DiscountCardServiceAbstract {

    private final DiscountCardRepository discountCardRepository;

    public DiscountCardService(DiscountCardRepository discountCardRepository) {
        this.discountCardRepository = discountCardRepository;
    }

    @Override
    public List<DiscountCard> findAll() {
        return discountCardRepository.findAll();
    }

    @Override
    public DiscountCard getDiscountCardById(Long id) throws ClassNotFoundException {
        if (discountCardRepository.findById(id).isPresent()) {
            return discountCardRepository.findById(id).orElse(null);
        } else {
            throw new ClassNotFoundException("Discount card with this id not found");
        }
    }

    @Override
    public DiscountCard create(DiscountCard discountCard) {
        return discountCardRepository.save(discountCard);
    }

    @Override
    public DiscountCard update(DiscountCard discountCard, Long id) throws ClassNotFoundException {
        DiscountCard existDiscountCard = discountCardRepository.findById(id).orElse(null);
        if (existDiscountCard != null) {
            existDiscountCard.setCardNumber(discountCard.getCardNumber());
            discountCardRepository.save(existDiscountCard);
        } else {
            throw new ClassNotFoundException("Discount card with this id not found");
        }
        return existDiscountCard;
    }

    @Override
    public void delete(Long id) throws ClassNotFoundException {
        if (discountCardRepository.findById(id).isPresent()) {
            discountCardRepository.deleteById(id);
        } else {
            throw new ClassNotFoundException("Discount card with this id not found");
        }
    }
}
