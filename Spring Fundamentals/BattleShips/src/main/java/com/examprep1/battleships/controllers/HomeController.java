package com.examprep1.battleships.controllers;

import com.examprep1.battleships.services.ship.ShipService;
import com.examprep1.battleships.services.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class HomeController {

    private final UserService userService;
    private final ShipService shipService;

    public HomeController(UserService userService, ShipService shipService) {
        this.userService = userService;
        this.shipService = shipService;
    }

    @ModelAttribute("ownShips")
    public String[] getOwnShips() {
        return this.shipService.getOwnShips();
    }

    @ModelAttribute("enemyShips")
    public String[] getEnemyShips() {
        return this.shipService.getEnemyShips();
    }

    @ModelAttribute("allShips")
    public String[] getAllShips() {
        return this.shipService.getAllShipsSorted();
    }

    @GetMapping(path = "home")
    public String getHome() {
        if (!this.userService.hasLoggedUsed()) {
            return "redirect:/user/login";
        }

        return "/home";
    }

    @GetMapping(path = "/")
    public String getIndex() {
        return "index";
    }
}
