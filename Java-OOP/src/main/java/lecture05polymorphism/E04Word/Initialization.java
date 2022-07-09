package lecture05polymorphism.E04Word;

public class Initialization implements CommandInterface {
    private StringBuilder text;
    private CommandImpl commandImpl;

    public static CommandInterface buildCommandInterface(StringBuilder text) {
        return new Initialization(text);
    }

    public Initialization(StringBuilder text) {
        this.text = text;
        init();
    }


    @Override
    public void init() {
        this.commandImpl = new CommandImpl(this.text);
        this.commandImpl.init();
    }

    @Override
    public void handleInput(String input) {
        this.commandImpl.handleInput(input);
    }
}
