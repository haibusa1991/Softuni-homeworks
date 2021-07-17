package lecture03;

import java.util.Scanner;

public class E01Cinema {
    public static void main(String[] args) {
        Scanner scanner = new  Scanner(System.in);

        String projectionType = scanner.nextLine();
        int rows = Integer.parseInt(scanner.nextLine());
        int columns = Integer.parseInt(scanner.nextLine());

        double price =5.0;

        switch (projectionType) {
            case "Premiere":
                price=12;
                break;
            case "Normal":
                price=7.5;
                break;
        }
        System.out.printf("%.2f leva",rows*columns*price);
    }
}
