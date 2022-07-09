package lecture07Reflection.E03_E04_E05BarracksWars.core.commands;

public class Fight extends Command {

    protected Fight(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        return "fight";
    }
}
