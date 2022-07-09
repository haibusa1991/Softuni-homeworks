package lecture04Interfaces.E06MilitaryElite;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    static List<Private> privates = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();


        while (!input.equals("End")) {
            String[] tokens = input.split(" ");
            String soldierType = tokens[0];
            int id = Integer.parseInt(tokens[1]);
            String firstName = tokens[2];
            String lastName = tokens[3];

            SoldierImpl currentSoldier = null;

            switch (soldierType) {
                case "Private":
                    currentSoldier = new Private(id, firstName, lastName, Double.parseDouble(tokens[4]));
                    privates.add((Private) currentSoldier);
                    break;

                case "Spy":
                    currentSoldier = new Spy(id, firstName, lastName, tokens[4]);
                    break;

                case "LieutenantGeneral":
                    List<Private> currentLtPrivates = new ArrayList<>();

                    for (int i = 5; i < tokens.length; i++) {
                        currentLtPrivates.add(getPrivate(Integer.parseInt(tokens[i])));
                    }

                    currentSoldier = new LieutenantGeneral(id, firstName, lastName, Double.parseDouble(tokens[4]), currentLtPrivates);
                    break;

                case "Engineer":
                    List<Repair> repairs = new ArrayList<>();

                    for (int i = 6; i < tokens.length; i += 2) {
                        repairs.add(new Repair(tokens[i], Integer.parseInt(tokens[i + 1])));
                    }
                    try {
                        currentSoldier = new Engineer(id, firstName, lastName, Double.parseDouble(tokens[4]), Corps.valueOf(tokens[5].toUpperCase()), repairs);
                    } catch (Exception ignored) {
                    }
                    break;
                case "Commando":
                    List<Mission> missions = new ArrayList<>();
                    for (int i = 6; i < tokens.length; i += 2) {
                        try {
                            MissionStatus status;
                            if (tokens[i + 1].equals("inProgress")) {
                                status = MissionStatus.IN_PROGRESS;
                            } else {
                                status = MissionStatus.valueOf(tokens[i + 1].toUpperCase());
                            }
                            missions.add(new Mission(tokens[i], status));
                        } catch (Exception ignored) {
                        }
                    }

                    try {

                        currentSoldier = new Commando(id, firstName, lastName, Double.parseDouble(tokens[4]), Corps.valueOf(tokens[5].toUpperCase()), missions);
                    } catch (Exception ignored) {

                    }
                    break;
            }
            if (currentSoldier != null) {
                System.out.println(currentSoldier);
            }
            input = scanner.nextLine();
        }

    }

    private static Private getPrivate(int id) {
        return privates.stream().filter(e -> e.getId() == id).collect(Collectors.toList()).get(0);
    }
}
