package glacialExpedition.models.explorers;

public class NaturalExplorer extends BaseExplorer {
    private static final int INITIAL_ENERGY = 60;
    private static final int ENERGY_DECREASE = 7;

    public NaturalExplorer(String name) {
        super(name, INITIAL_ENERGY);
    }

    @Override
    public void search() {
        if (super.getEnergy() - ENERGY_DECREASE < 0) {
            this.setEnergy(0);
        }else {
            this.setEnergy(super.getEnergy() - ENERGY_DECREASE);
        }
    }
}


