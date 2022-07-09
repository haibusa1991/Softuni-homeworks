package lecture03;

import java.util.Scanner;

public class L02WeekendOrWorkingDay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String dayInput = scanner.nextLine();
        String dayOutput = "";

        switch (dayInput) {
            case "Monday":
            case "Tuesday":
            case "Wednesday":
            case "Thursday":
            case "Friday":
                dayOutput = "Working day";
                break;
            case "Saturday":
            case "Sunday":
                dayOutput = "Weekend";
                break;
            default:
                dayOutput = "Error";
                break;

        }
        System.out.println(dayOutput);
    }
}
