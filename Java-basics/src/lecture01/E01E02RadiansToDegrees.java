package lecture01;

import java.util.Scanner;

public class E01E02RadiansToDegrees {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double radians = Double.parseDouble(sc.nextLine());
        System.out.printf("%.0f",radians*180/Math.PI);
    }
}
