package lecture07Reflection.E03_E04_E05BarracksWars.core.commands;

import lecture07Reflection.E03_E04_E05BarracksWars.interfaces.Executable;

public abstract class Command implements Executable {

    private String[] data;

    protected Command(String[] data) {
        this.data = data;
    }

    protected String[] getData() {
        return data;
    }
}
