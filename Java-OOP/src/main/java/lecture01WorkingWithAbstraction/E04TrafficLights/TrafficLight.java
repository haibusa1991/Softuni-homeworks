package lecture01WorkingWithAbstraction.E04TrafficLights;

public class TrafficLight {
    private Colour colour;

    public TrafficLight(String colour) {
        this.colour = Colour.valueOf(colour);
    }

    public void nextLight() {
        switch (colour) {
            case RED:
                colour = Colour.GREEN;
                break;
            case GREEN:
                colour = Colour.YELLOW;
                break;
            case YELLOW:
                colour = Colour.RED;
                break;
        }
    }

    @Override
    public String toString() {
        return colour.name();
    }
}
