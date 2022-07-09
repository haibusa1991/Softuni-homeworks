package lecture08UnitTesting.l01_rpg_lab;

public abstract class WeaponImpl implements Weapon {
    private Type type = Type.WEAPON;

    public Type getType() {
        return type;
    }
}
