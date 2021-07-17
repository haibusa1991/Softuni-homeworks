package lecture03;

import java.util.Scanner;

public class E09Volleyball {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String leap = scanner.nextLine();
        boolean isLeapYear = leap.equals("leap");

        int numHolidays = Integer.parseInt(scanner.nextLine());
        int numTravelledWeekends = Integer.parseInt(scanner.nextLine());

        double numPlayedGames = 1.0*(48-numTravelledWeekends)*3/4+numTravelledWeekends + 1.0*2/3*numHolidays;
        if (isLeapYear){
            numPlayedGames*=1.15;
        }
        System.out.printf("%.0f", Math.floor(numPlayedGames));

    }
}
