package com.examprep1.battleships.services.ship;

import com.examprep1.battleships.binding.AddShipForm;
import com.examprep1.battleships.binding.ShipBattle;
import com.examprep1.battleships.entities.Ship;

public interface ShipService {

    void addShip(AddShipForm addShipForm);

    String[] getOwnShips();

    String[] getEnemyShips();

    String[] getAllShipsSorted();

    void resolveShipBattle(ShipBattle shipBattle);
}
