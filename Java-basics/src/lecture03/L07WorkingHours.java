package lecture03;

import java.util.Scanner;

public class L07WorkingHours {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hours = Integer.parseInt(scanner.nextLine());
        String day = scanner.nextLine();

        boolean isWorkday = true;
        boolean isWorkhours = false;

        if (day.equals("Sunday")) {
            isWorkday = false;
        }

        if (hours >= 10 && hours < 18) {
            isWorkhours = true;
        }

        if (isWorkday && isWorkhours) {
            System.out.println("open");
        } else {
            System.out.println("closed");


        }
    }
}
