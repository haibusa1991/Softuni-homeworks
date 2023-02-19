package com.reseller.services.offer;

import com.reseller.binding.AddOfferForm;
import com.reseller.entities.Offer;

import java.util.Set;

public interface OfferService {
    void saveOffer(AddOfferForm addOfferForm);

    Set<Offer> getOwnOffers();

    Offer getOfferById(String offerId);

    void deleteOfferById(String offerId);

    Set<Offer> getBoughtOffers();


    int getOffersCount();

    void buyItem(String offerId);
}
