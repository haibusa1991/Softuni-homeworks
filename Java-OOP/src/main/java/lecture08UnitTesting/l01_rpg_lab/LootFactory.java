package lecture08UnitTesting.l01_rpg_lab;

import java.util.Random;

public class LootFactory {
    private final static int MAX_ATTACK = 5;
    private final static int MAX_DURABILITY = 10;

    public static Loot getRandomAxe() {
        Random random = new Random();
        int attack = random.nextInt(MAX_ATTACK);
        int durability = random.nextInt(MAX_DURABILITY);
        return new Axe(attack, durability);
    }
}
