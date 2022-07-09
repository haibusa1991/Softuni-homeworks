package lecture07Reflection.E03_E04_E05BarracksWars.core.commands;

import lecture07Reflection.E03_E04_E05BarracksWars.interfaces.Repository;

public class Retire extends Command {
    @Inject
    private Repository repository;

    protected Retire(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        String unitName = super.getData()[1];
        try {
            this.repository.removeUnit(unitName);
            return unitName + " retired!";
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }
}
