package com.reseller.controllers;

import com.reseller.entities.Offer;
import com.reseller.entities.User;
import com.reseller.services.offer.OfferService;
import com.reseller.services.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;
import java.util.Set;

@Controller
public class HomeController {

    private final UserService userService;
    private final OfferService offerService;

    public HomeController(UserService userService, OfferService offerService) {
        this.userService = userService;
        this.offerService = offerService;
    }

    @ModelAttribute("ownOffers")
    public Set<Offer> getOwnOffers() {
        return this.offerService.getOwnOffers();
    }

    @ModelAttribute("boughtOffers")
    public Set<Offer> getBoughtOffers() {
        return this.offerService.getBoughtOffers();
    }

    @ModelAttribute("offerCount")
    public int getOfferCount() {
        return this.offerService.getOffersCount();
    }

    @ModelAttribute("otherOffers")
    public List<User> getOtherOffers() {
        return this.userService.getAllOtherUsers();
    }

    @GetMapping("/")
    private String getHome() {
        if (this.userService.hasUser()) {
            return "home";
        }

        return "index";
    }
}
