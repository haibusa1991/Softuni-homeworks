package midExamExercise;
//https://judge.softuni.bg/Contests/Practice/Index/1773#2

import java.util.Arrays;
import java.util.Scanner;

public class M18ManOWar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] pirateShip = Arrays.stream(scanner.nextLine().split(">"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] warShip = Arrays.stream(scanner.nextLine().split(">"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int maxSectionHealth = Integer.parseInt(scanner.nextLine());

        String input = scanner.nextLine();
        boolean isPirateShipSunken = false;
        boolean isWarShipSunken = false;

        while (!input.equals("Retire")) {
            String command = input.split(" ")[0];

            switch (command) {
                case "Fire": {
                    String[] data = input.split(" ");
                    int targetSection = Integer.parseInt(data[1]);
                    int targetSectionDamage = Integer.parseInt(data[2]);
                    if (targetSection >= 0 && targetSection < warShip.length) {
                        warShip[targetSection] -= targetSectionDamage;
                        if (warShip[targetSection] <= 0) {
                            isWarShipSunken = true;
                        }
                    }
                }
                break;
                case "Defend": {
                    String[] data = input.split(" ");
                    int targetSectionStartIndex = Integer.parseInt(data[1]);
                    int targetSectionEndIndex = Integer.parseInt(data[2]);
                    int targetSectionDamage = Integer.parseInt(data[3]);
                    if (targetSectionStartIndex >= 0
                            && targetSectionStartIndex < pirateShip.length
                            && targetSectionEndIndex >= 0
                            && targetSectionEndIndex < pirateShip.length) {
                        for (int i = targetSectionStartIndex; i <= targetSectionEndIndex; i++) {
                            pirateShip[i] -= targetSectionDamage;
                            if (pirateShip[i] <= 0) {
                                isPirateShipSunken = true;
                            }
                        }
                    }

                }
                break;
                case "Repair": {
                    String[] data = input.split(" ");
                    int targetSection = Integer.parseInt(data[1]);
                    int targetSectionHealth = Integer.parseInt(data[2]);
                    if (targetSection >= 0 && targetSection < pirateShip.length) {
                        pirateShip[targetSection] += targetSectionHealth;
                        if (pirateShip[targetSection] > maxSectionHealth) {
                            pirateShip[targetSection] = maxSectionHealth;
                        }
                    }
                }
                break;
                case "Status":
                    int numSectionsToRepair = 0;
                    for (int sectionHealth : pirateShip) {
                        if (sectionHealth < 0.2 * maxSectionHealth) {
                            numSectionsToRepair++;
                        }
                    }
                    System.out.printf("%d sections need repair.\n", numSectionsToRepair);
                    break;
            }

            if (isPirateShipSunken || isWarShipSunken) {
                break;
            }
            input = scanner.nextLine();
        }
        if (isPirateShipSunken) {
            System.out.println("You lost! The pirate ship has sunken.");
        } else if (isWarShipSunken) {
            System.out.println("You won! The enemy ship has sunken.");
        } else {
            int pirateShipHealth = Arrays.stream(pirateShip).sum();
            int warShipHealth = Arrays.stream(warShip).sum();
            System.out.printf("Pirate ship status: %d\nWarship status: %d", pirateShipHealth, warShipHealth);
        }
    }
}
