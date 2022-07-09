package lecture04;

import java.util.Scanner;

public class E06Salary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numTabs = Integer.parseInt(scanner.nextLine());
        double salary = Double.parseDouble(scanner.nextLine());

        for (int i = 0; i < numTabs; i++) {
            String currentTab = scanner.nextLine();

            switch (currentTab) {
                case "Facebook":
                    salary -= 150;
                    break;
                case "Instagram":
                    salary -= 100;
                    break;
                case "Reddit":
                    salary -= 50;
                    break;
            }

            if (salary <= 0) {
                System.out.println("You have lost your salary.");
                break;
            }

        }
        if (salary > 0) {
            System.out.printf("%.0f", salary);
        }
    }
}
