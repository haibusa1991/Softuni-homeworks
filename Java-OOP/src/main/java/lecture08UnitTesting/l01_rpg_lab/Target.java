package lecture08UnitTesting.l01_rpg_lab;

public interface Target {

    int getHealth();

    void takeAttack(int attackPoints);

    int giveExperience();

    boolean isDead();

    Loot dropLoot();
}
