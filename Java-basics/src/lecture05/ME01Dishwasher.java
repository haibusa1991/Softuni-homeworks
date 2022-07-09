package lecture05;

import java.util.Scanner;

public class ME01Dishwasher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int bottlesSoap = Integer.parseInt(scanner.nextLine());
        int soap = bottlesSoap * 750;

        boolean hasEnded = false;
        int loadingCycle = 0;

        int dishes = 0;
        int pots = 0;

        while (soap >= 0) {
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("end")) {
                hasEnded = true;
                break;
            }

            int currentValue = Integer.parseInt(input);
            if (loadingCycle == 2) {
                soap -= currentValue * 15;
                loadingCycle = 0;
                pots += currentValue;
            } else {
                soap -= currentValue * 5;
                loadingCycle++;
                dishes += currentValue;
            }
        }
        if (hasEnded) {
            System.out.printf("Detergent was enough!\n%d dishes and %d pots were washed.\nLeftover detergent %d ml.", dishes, pots, soap);
        } else {
            System.out.printf("Not enough detergent, %d ml. more necessary!", Math.abs(soap));
        }
    }
}
