package com.reseller.controllers;

import com.reseller.binding.AddOfferForm;
import com.reseller.entities.Offer;
import com.reseller.services.condition.ConditionService;
import com.reseller.services.offer.OfferService;
import com.reseller.services.user.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/offer")
public class OfferController {
    private final UserService userService;
    private final ConditionService conditionService;
    private final OfferService offerService;

    public OfferController(UserService userService, ConditionService conditionService, OfferService offerService) {
        this.userService = userService;
        this.conditionService = conditionService;
        this.offerService = offerService;
    }

    @ModelAttribute("addOfferForm")
    private AddOfferForm getAddOfferForm() {
        return new AddOfferForm();
    }

    @ModelAttribute("allConditions")
    private String[] getAllConditions() {
        return this.conditionService.getAllConditions();
    }

    @GetMapping("add-offer")
    public String getAddOffer() {
        if (this.userService.hasUser()) {
            return "offer-add";
        }

        return "redirect:/user/login";
    }

    @PostMapping("add-offer")
    public String publishOffer(@Valid AddOfferForm addOfferForm,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {

        if (!this.userService.hasUser()) {
            return "redirect:/user/login";
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addOfferForm", addOfferForm);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addOfferForm", bindingResult);

            return "redirect:add-offer";
        }

        this.offerService.saveOffer(addOfferForm);
        return "redirect:/";
    }

    @GetMapping(value = "/remove/{offerId}")
    public String removeOffer(@PathVariable String offerId) {

        boolean isOwnOffer = this.offerService.getOwnOffers()
                .stream()
                .anyMatch(e -> e.getId().toString().equals(offerId));

        if (isOwnOffer) {
            this.offerService.deleteOfferById(offerId);
        }

        return "redirect:/";
    }

    @GetMapping(value = "/buy/{offerId}")
    public String buyOffer(@PathVariable String offerId) {

        this.offerService.buyItem(offerId);

        return "redirect:/";
    }
}
