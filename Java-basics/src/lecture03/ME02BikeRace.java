package lecture03;

import java.util.Scanner;

public class ME02BikeRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int juniors = Integer.parseInt(scanner.nextLine());
        int seniors = Integer.parseInt(scanner.nextLine());
        String raceType = scanner.nextLine();

        double totalSum = 0;

        switch (raceType) {
            case "trail":
                totalSum = juniors * 5.5 + seniors * 7;
                break;
            case "cross-country":
                totalSum = juniors * 8 + seniors * 9.5;
                break;
            case "downhill":
                totalSum = juniors * 12.25 + seniors * 13.75;
                break;
            case "road":
                totalSum = juniors * 20 + seniors * 21.5;
                break;
        }

        if (raceType.equals("cross-country") && juniors+seniors>=50){
            totalSum*=0.75;
        }

        System.out.printf("%.2f",totalSum*0.95);

    }
}
