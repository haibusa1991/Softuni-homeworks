package lecture07Reflection.E03_E04_E05BarracksWars.models.units;

public class Gunner extends AbstractUnit {
    private static final int GUNNER_HEALTH = 50;
    private static final int GUNNER_DAMAGE = 10;

    public Gunner() {
        super(GUNNER_HEALTH, GUNNER_DAMAGE);
    }
}
