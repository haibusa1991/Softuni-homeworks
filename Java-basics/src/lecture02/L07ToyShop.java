package lecture02;

import java.util.Scanner;

public class L07ToyShop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double tripPrice =Double.parseDouble(sc.nextLine());
        int puzzlesCount = Integer.parseInt(sc.nextLine());
        int dollsCount = Integer.parseInt(sc.nextLine());
        int teddiesCount = Integer.parseInt(sc.nextLine());
        int minionsCount = Integer.parseInt(sc.nextLine());
        int trucksCount = Integer.parseInt(sc.nextLine());

        double toysPrice = puzzlesCount*2.6+
                dollsCount*3+
                teddiesCount*4.1+
                minionsCount*8.2+
                trucksCount*2;

        int toysNumTotal = puzzlesCount+
                dollsCount+
                teddiesCount+
                minionsCount+
                trucksCount;
        if (toysNumTotal>=50) {
            toysPrice *= .75;
        }
        double rent = toysPrice*.1;
        double totalExpenses = tripPrice+rent;

        if(totalExpenses<=toysPrice) {
            System.out.printf("Yes! %.2f lv left.",toysPrice-totalExpenses);
        } else {
            System.out.printf("Not enough money! %.2f lv needed.",totalExpenses-toysPrice);
        }


    }
}
