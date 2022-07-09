package lecture07Reflection.E03_E04_E05BarracksWars.core.commands;

import lecture07Reflection.E03_E04_E05BarracksWars.interfaces.Repository;

public class Report extends Command {
    @Inject
    private Repository repository;

    protected Report(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        return this.repository.getStatistics();
    }
}
