package lecture07Reflection.E03_E04_E05BarracksWars.interfaces;

public interface CommandInterpreter {

	Executable interpretCommand(String[] data, String commandName);
}
