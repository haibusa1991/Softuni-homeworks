package lecture04;

import java.util.Scanner;

public class ME02Hospital {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());

        int numDoctors = 7;
        int treatedPatients = 0;
        int untreatedPatients = 0;
        int daysCounter = 1;

        for (int i = 0; i < days; i++) {
            int dailyPatients = Integer.parseInt(scanner.nextLine());

            if (daysCounter == 3) {
                if (untreatedPatients > treatedPatients) {
                    numDoctors++;
                }
                daysCounter = 0;
            }

            daysCounter++;
            if (dailyPatients <= numDoctors) {
                treatedPatients += dailyPatients;
            } else {
                treatedPatients+=numDoctors;
                untreatedPatients += dailyPatients - numDoctors;
            }

        }
        System.out.printf("Treated patients: %d.\nUntreated patients: %d.", treatedPatients, untreatedPatients);
    }
}
