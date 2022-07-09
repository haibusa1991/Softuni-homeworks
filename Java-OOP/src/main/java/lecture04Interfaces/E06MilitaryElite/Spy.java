package lecture04Interfaces.E06MilitaryElite;

public class Spy extends SoldierImpl {
    private final String codeNumber;

    public Spy(int id, String firstName, String lastName, String codeNumber) {
        super(id, firstName, lastName);
        this.codeNumber = codeNumber;
    }

    @Override
    public String toString() {
        return super.toString() + System.lineSeparator() + String.format("Code Number: %s", codeNumber);
    }
}
