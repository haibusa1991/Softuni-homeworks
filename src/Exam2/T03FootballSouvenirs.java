package Exam2;

import java.util.Scanner;

public class T03FootballSouvenirs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String teamName = scanner.nextLine();
        String souvenirType = scanner.nextLine();
        int numSouvenirs = Integer.parseInt(scanner.nextLine());

        double souvenirPrice = 0;
        boolean isInvalidSouvenir = false;
        boolean isInvalidTeam = false;

        switch (teamName) {
            case "Argentina":
                switch (souvenirType) {
                    case "flags":
                        souvenirPrice = 3.25;
                        break;
                    case "caps":
                        souvenirPrice = 7.2;
                        break;
                    case "posters":
                        souvenirPrice = 5.1;
                        break;
                    case "stickers":
                        souvenirPrice = 1.25;
                        break;
                    default:
                        isInvalidSouvenir = true;
                        break;
                }
                break;
            case "Brazil":
                switch (souvenirType) {
                    case "flags":
                        souvenirPrice = 4.2;
                        break;
                    case "caps":
                        souvenirPrice = 8.5;
                        break;
                    case "posters":
                        souvenirPrice = 5.35;
                        break;
                    case "stickers":
                        souvenirPrice = 1.2;
                        break;
                    default:
                        isInvalidSouvenir = true;
                        break;
                }
                break;
            case "Croatia":
                switch (souvenirType) {
                    case "flags":
                        souvenirPrice = 2.75;
                        break;
                    case "caps":
                        souvenirPrice = 6.9;
                        break;
                    case "posters":
                        souvenirPrice = 4.95;
                        break;
                    case "stickers":
                        souvenirPrice = 1.1;
                        break;
                    default:
                        isInvalidSouvenir = true;
                        break;
                }
                break;
            case "Denmark":
                switch (souvenirType) {
                    case "flags":
                        souvenirPrice = 3.1;
                        break;
                    case "caps":
                        souvenirPrice = 6.5;
                        break;
                    case "posters":
                        souvenirPrice = 4.8;
                        break;
                    case "stickers":
                        souvenirPrice = 0.9;
                        break;
                    default:
                        isInvalidSouvenir = true;
                        break;
                }
                break;
            default:
                isInvalidTeam = true;
                break;
        }
        if (isInvalidSouvenir) {
            System.out.println("Invalid stock!");

        } else if (isInvalidTeam) {
            System.out.println("Invalid country!");
        } else {
            System.out.printf("Pepi bought %d %s of %s for %.2f lv.", numSouvenirs, souvenirType, teamName, numSouvenirs * souvenirPrice);
        }
    }
}
