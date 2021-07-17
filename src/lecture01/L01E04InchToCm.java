package lecture01;

import java.util.Scanner;

public class L01E04InchToCm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double inches = Double.parseDouble(sc.nextLine());
        System.out.println(inches*2.54);

    }
}
