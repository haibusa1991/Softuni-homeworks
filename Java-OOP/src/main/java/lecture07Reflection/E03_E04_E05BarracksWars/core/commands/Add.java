package lecture07Reflection.E03_E04_E05BarracksWars.core.commands;

import lecture07Reflection.E03_E04_E05BarracksWars.interfaces.Repository;
import lecture07Reflection.E03_E04_E05BarracksWars.interfaces.Unit;
import lecture07Reflection.E03_E04_E05BarracksWars.interfaces.UnitFactory;

public class Add extends Command {
    @Inject
    private Repository repository;
    @Inject
    private UnitFactory unitFactory;

    protected Add(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        String unitType = super.getData()[1];
        Unit unitToAdd = this.unitFactory.createUnit(unitType);
        this.repository.addUnit(unitToAdd);
        return unitType + " added!";
    }
}
