package lecture01;

import java.util.Scanner;

public class ME02TriangleArea {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = Double.parseDouble(sc.nextLine());
        double h = Double.parseDouble(sc.nextLine());
        System.out.printf("%.2f", a*h/2);
    }
}
