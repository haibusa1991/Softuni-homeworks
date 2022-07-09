package lecture03;

import java.util.Scanner;

public class L01DayOfWeek {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int day = Integer.parseInt(scanner.nextLine());
        String dayOut = "";

        switch (day) {
            case 1:
                dayOut = "Monday";
                break;

            case 2:
                dayOut = "Tuesday";
                break;

            case 3:
                dayOut = "Wednesday";
                break;

            case 4:
                dayOut = "Thursday";
                break;

            case 5:
                dayOut = "Friday";
                break;

            case 6:
                dayOut = "Saturday";
                break;

            case 7:
                dayOut = "Sunday";
                break;
            default:
                dayOut = "Error";
                break;
        }
        System.out.println(dayOut);
    }
}

