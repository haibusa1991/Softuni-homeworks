package finalExamExcercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

//https://judge.softuni.bg/Contests/Practice/Index/1443#1
public class FEE18SantasGifts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCommands = Integer.parseInt(scanner.nextLine());
        List<String> houses = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        int currentPos = 0;
        for (int i = 0; i < numCommands; i++) {
            String[] data = scanner.nextLine().split(" ");
            String command = data[0];
            switch (command) {
                case "Forward": {
                    int numSteps = Integer.parseInt(data[1]);
                    if (currentPos + numSteps < houses.size()) {
                        currentPos += numSteps;
                        houses.remove(currentPos);
                    }
                    break;
                }
                case "Back": {
                    int numSteps = Integer.parseInt(data[1]);
                    if (currentPos - numSteps >= 0) {
                        currentPos -= numSteps;
                        houses.remove(currentPos);
                    }
                    break;
                }
                case "Gift": {
                    int index = Integer.parseInt(data[1]);
                    if (index >= 0 && index < houses.size()) {
                        String houseNumber = data[2];
                        houses.add(index, houseNumber);
                        currentPos = index;
                    }
                    break;
                }
                case "Swap": {
                    String value1 = data[1];
                    String value2 = data[2];
                    if (houses.contains(value1) && houses.contains(value2)) {
                        int index1 = houses.indexOf(value1);
                        int index2 = houses.indexOf(value2);
                        houses.set(index1, value2);
                        houses.set(index2, value1);
                    }
                    break;
                }
            }
        }
        System.out.println("Position: " + currentPos);
        System.out.println(houses.toString().replaceAll("[\\[\\]]", ""));
    }
}
