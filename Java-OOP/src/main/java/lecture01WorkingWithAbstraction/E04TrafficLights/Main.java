package lecture01WorkingWithAbstraction.E04TrafficLights;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] initialStates = scanner.nextLine().split(" ");
        List<TrafficLight> lights = new ArrayList<>();
        for (String initialState : initialStates) {
            lights.add(new TrafficLight(initialState));
        }

        int numSwitches = Integer.parseInt(scanner.nextLine());

        while (numSwitches-- > 0) {
            for (TrafficLight light : lights) {
                light.nextLight();
                System.out.print(light + " ");
            }
            System.out.println();
        }
    }
}
