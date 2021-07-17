package lecture04;

import java.util.Scanner;

public class ME01BackToThePast {
    public static void main(String[] args) {
        Scanner scanner = new  Scanner(System.in);

        double inheritance = Double.parseDouble(scanner.nextLine());
        int targetYear=Integer.parseInt(scanner.nextLine());

        for (int i = 1800; i <=targetYear ; i++) {
            if (i%2==0) {
                inheritance -= 12000;
            }else {
                inheritance-=12000+(i-1800+18)*50;
            }

        }
        if (inheritance>=0){
            System.out.printf("Yes! He will live a carefree life and will have %.2f dollars left.",inheritance);
        }else {
            System.out.printf("He will need %.2f dollars to survive.", inheritance*-1);
        }
    }
}
