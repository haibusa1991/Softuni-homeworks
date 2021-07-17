package Exam2;

import java.util.Scanner;

public class T01MiningRig {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int videocardPrice = Integer.parseInt(scanner.nextLine());
        int raiserPrice = Integer.parseInt(scanner.nextLine());
        double electricityPricePerDay = Double.parseDouble(scanner.nextLine());
        double winningPerDay = Double.parseDouble(scanner.nextLine());

        int rigPrice = 13 * videocardPrice + 13 * raiserPrice + 1000;
        int ROI = (int) Math.ceil(rigPrice / ((winningPerDay - electricityPricePerDay) * 13));
        System.out.printf("%d\n%d", rigPrice, ROI);
    }
}
