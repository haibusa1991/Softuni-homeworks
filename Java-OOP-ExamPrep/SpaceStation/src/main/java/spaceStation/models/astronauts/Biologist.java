package spaceStation.models.astronauts;

public class Biologist extends BaseAstronaut {
    private static final double INITIAL_OXYGEN = 70;
    private static final int BREATH_DECREASE = 5;


    public Biologist(String name) {
        super(name, INITIAL_OXYGEN);
    }

    @Override
    public void breath() {
        super.setOxygen(Math.max(0, super.getOxygen() - INITIAL_OXYGEN));
    }
}
