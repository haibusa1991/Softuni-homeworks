package lecture01;

import java.util.Scanner;

public class E01E03DepositCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double deposit = Double.parseDouble(sc.nextLine());
        int term = Integer.parseInt(sc.nextLine());
        double interest = Double.parseDouble(sc.nextLine());
        System.out.println(deposit+term*deposit*interest/100/12);
    }
}
