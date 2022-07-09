package lecture03;

import java.util.Scanner;

public class L01DayOfWeek {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] days = {"Monday",
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday",
                "Sunday"};

        int input = Integer.parseInt(scanner.nextLine());
        try {
            System.out.println(days[input - 1]);
        } catch (Exception e) {
            System.out.println("Invalid day!");
        }

    }
}
