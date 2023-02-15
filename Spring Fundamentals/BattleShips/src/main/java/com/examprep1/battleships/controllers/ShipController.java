package com.examprep1.battleships.controllers;

import com.examprep1.battleships.binding.AddShipForm;
import com.examprep1.battleships.binding.ShipBattle;
import com.examprep1.battleships.services.category.CategoryService;
import com.examprep1.battleships.services.ship.ShipService;
import com.examprep1.battleships.services.user.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/ships")
public class ShipController {
    private final UserService userService;
    private final ShipService shipService;
    private final CategoryService categoryService;

    public ShipController(UserService userService,
                          ShipService shipService, CategoryService categoryService) {
        this.userService = userService;
        this.shipService = shipService;
        this.categoryService = categoryService;
    }

    @ModelAttribute("addShipForm")
    public AddShipForm getAddShipDto() {
        return new AddShipForm();
    }

    @ModelAttribute("shipCategories")
    public String[] getShipCategories() {
        return this.categoryService.getAllShipCategories();
    }

    @GetMapping("/add-ship")
    public String getAddShip() {
        if (!this.userService.hasLoggedUsed()) {
            return "redirect:/user/login";
        }
        return "ship-add";
    }

    @PostMapping("/add-ship")
    public String addShip(@Valid AddShipForm addShipForm,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes) {

        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("addShipForm", addShipForm);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addShipForm",bindingResult);

            return "redirect:add-ship";
        }

        this.shipService.addShip(addShipForm);
        return "redirect:/home";
    }

    @PostMapping("/battle")
    public String shipBattle(@Valid ShipBattle shipBattle,
                             BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "redirect:/home";
        }

        this.shipService.resolveShipBattle(shipBattle);
        return "redirect:/home";
    }

}
