package lecture08UnitTesting.l01_rpg_lab;

public interface Weapon extends Loot {

     int getAttackPoints();

     int getDurabilityPoints();

     void attack(Target target);
}
