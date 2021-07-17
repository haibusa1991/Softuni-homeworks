package lecture02;

import java.util.Scanner;

public class ME04TransportPrice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int distance = Integer.parseInt(sc.nextLine());
        String timeOfDay = sc.nextLine();

        double taxiPrice = .7 + distance * .79;
        double busPrice = distance * .09;
        double trainPrice = distance * .06;

        if (timeOfDay.equals("night")) {
            taxiPrice = .7 + distance * .9;
        }
        if (distance < 20) {
            System.out.printf("%.2f",taxiPrice);
        } else if (distance < 100) {
            System.out.printf("%.2f",busPrice);
        } else {
            System.out.printf("%.2f",trainPrice);
        }
    }
}
