package lecture08UnitTesting.l01_rpg_lab;

import java.util.ArrayList;
import java.util.List;

public class Hero {

    private String name;
    private int experience;
    private Weapon weapon;
    private List<Loot> inventory;

    public Hero(String name) {
        this.name = name;
        this.experience = 0;
        this.inventory = new ArrayList<>();
        this.weapon = new Axe(10, 10);
    }

    public Hero(String name, Weapon weapon) {
        this(name);
        this.weapon = weapon;
    }

    public String getName() {
        return this.name;
    }

    public int getExperience() {
        return this.experience;
    }

    public Weapon getWeapon() {
        return this.weapon;
    }

    public void attack(Target target) {
        this.weapon.attack(target);

        if (target.isDead()) {
            this.experience += target.giveExperience();
        }
    }

    public void takeLoot(Loot loot) {
        if (loot != null) {
            this.inventory.add(loot);
        }
    }

    public List<Loot> getInventory() {
        return inventory;
    }
}
