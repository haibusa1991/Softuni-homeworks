package com.examprep1.battleships.binding;

import jakarta.validation.constraints.NotBlank;

public class ShipBattle {
    @NotBlank
    public String ownShipName;

    @NotBlank
    public String enemyShipName;

    public String getOwnShipName() {
        return ownShipName;
    }

    public void setOwnShipName(String ownShipName) {
        this.ownShipName = ownShipName;
    }

    public String getEnemyShipName() {
        return enemyShipName;
    }

    public void setEnemyShipName(String enemyShipName) {
        this.enemyShipName = enemyShipName;
    }
}
