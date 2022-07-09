package lecture01;

import java.util.Scanner;

public class ME03CelsiusToFahrenheit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double celsius = Double.parseDouble(sc.nextLine());
        System.out.printf("%.2f", celsius*9/5+32);
    }
}
