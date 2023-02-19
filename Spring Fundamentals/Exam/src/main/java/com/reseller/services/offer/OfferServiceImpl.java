package com.reseller.services.offer;

import com.reseller.binding.AddOfferForm;
import com.reseller.entities.Condition;
import com.reseller.entities.Offer;
import com.reseller.entities.User;
import com.reseller.repositories.OfferRepository;
import com.reseller.services.condition.ConditionService;
import com.reseller.services.user.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final ModelMapper modelMapper;
    private final ConditionService conditionService;
    private final UserService userService;

    public OfferServiceImpl(OfferRepository offerRepository, ModelMapper modelMapper, ConditionService conditionService, UserService userService) {
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
        this.conditionService = conditionService;
        this.userService = userService;
    }

    @Override
    public void saveOffer(AddOfferForm addOfferForm) {

        Offer offer = this.modelMapper.map(addOfferForm, Offer.class);
        Condition condition = this.conditionService.getConditionByName(addOfferForm.getCondition());
        offer.setCondition(condition);

        Offer persisted = this.offerRepository.save(offer);

        User currentUser = this.userService.getCurrentUser();
        currentUser.getOffers().add(persisted);
        this.userService.saveUser(currentUser);
    }

    @Override
    public Set<Offer> getOwnOffers() {
        if (this.userService.hasUser()) {
            return this.userService.getCurrentUser().getOffers();
        }

        return new HashSet<>();
    }

    @Override
    public Offer getOfferById(String offerId) {
        return this.offerRepository.getOfferById(UUID.fromString(offerId));

    }

    @Override
    public void deleteOfferById(String offerId) {
        this.offerRepository.deleteById(UUID.fromString(offerId));
    }

    @Override
    public Set<Offer> getBoughtOffers() {
        if (this.userService.hasUser()) {
            return this.userService.getCurrentUser().getBoughtOffers();
        }

        return new HashSet<>();
    }


    @Override
    public int getOffersCount() {
        if (!this.userService.hasUser()) {
            return -1;
        }

        AtomicInteger result = new AtomicInteger();

        this.userService.getAllUsers()
                .stream()
                .filter(e -> !e.getUsername().equals(this.userService.getCurrentUser().getUsername()))
                .forEach(e -> result.addAndGet(e.getOffers().size()));

        return result.get();
    }

    @Override
    public void buyItem(String offerId) {
        Offer offer = offerRepository.getOfferById(UUID.fromString(offerId));
        User seller = offer.getSeller();
        User buyer = this.userService.getCurrentUser();

        seller.removeOffer(offer);
        this.userService.saveUser(seller);

        buyer.addBoughtOffer(offer);
        this.userService.saveUser(buyer);

    }
}
