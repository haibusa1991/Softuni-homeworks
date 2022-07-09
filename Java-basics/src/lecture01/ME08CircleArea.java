package lecture01;

import java.util.Scanner;

public class ME08CircleArea {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double radius = Double.parseDouble(sc.nextLine());

        System.out.printf("%.2f\n%.2f",Math.PI*radius*radius,2*Math.PI*radius);
    }
}
