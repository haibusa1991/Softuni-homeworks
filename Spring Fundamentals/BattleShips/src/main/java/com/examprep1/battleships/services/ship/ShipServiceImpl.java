package com.examprep1.battleships.services.ship;

import com.examprep1.battleships.binding.AddShipForm;
import com.examprep1.battleships.binding.ShipBattle;
import com.examprep1.battleships.entities.Category;
import com.examprep1.battleships.entities.Ship;
import com.examprep1.battleships.entities.User;
import com.examprep1.battleships.repositories.ShipRepository;
import com.examprep1.battleships.services.user.UserService;
import com.examprep1.battleships.services.category.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipServiceImpl implements ShipService {


    private final UserService userService;
    private final ModelMapper modelMapper;
    private final CategoryService categoryService;
    private final ShipRepository shipRepository;

    public ShipServiceImpl(UserService userService,
                           ModelMapper modelMapper,
                           CategoryService categoryService,
                           ShipRepository shipRepository) {
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
        this.shipRepository = shipRepository;
    }


    @Override
    public void addShip(AddShipForm addShipForm) {
        Ship ship = this.modelMapper.map(addShipForm, Ship.class);

        Category category = this.categoryService.getCategory(addShipForm.getCategory());
        ship.setCategory(category);

        User shipUser = this.userService.getCurrentUser();
        ship.setUser(shipUser);

        this.shipRepository.save(ship);
    }

    @Override
    public String[] getOwnShips() {
        if (this.userService.hasLoggedUsed()) {
            return this.shipRepository.getOwnShipsNames(this.userService.getCurrentUser().getUsername());
        }
        return new String[0];
    }

    @Override
    public String[] getEnemyShips() {
        if (this.userService.hasLoggedUsed()) {
            return this.shipRepository.getEnemyShipsNames(this.userService.getCurrentUser().getUsername());
        }
        return new String[0];
    }

    @Override
    public String[] getAllShipsSorted() {
        List<Ship> allShips = this.shipRepository.getAllByOrderByNameAscHealthAscPowerAsc();

        return allShips.stream().map(e ->
                        e.getName() +
                        "--" +
                        e.getHealth() +
                        "--" +
                        e.getPower())
                .toArray(String[]::new);

    }

    @Override
    public void resolveShipBattle(ShipBattle shipBattle) {
        Ship ownShip = this.shipRepository.getShipByName(shipBattle.getOwnShipName());
        Ship enemyShip = this.shipRepository.getShipByName(shipBattle.getEnemyShipName());

        boolean isDestroyed = enemyShip.getHealth() - ownShip.getPower() <= 0;

        if (isDestroyed) {
            this.shipRepository.delete(enemyShip);
            return;
        }

        enemyShip.setHealth(enemyShip.getHealth() - ownShip.getPower());
        this.shipRepository.saveAndFlush(enemyShip);
    }

}
