package lecture04;

import java.util.Scanner;

public class L06CalculateRectangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double height = Double.parseDouble(scanner.nextLine());
        double width = Double.parseDouble(scanner.nextLine());

        System.out.printf("%.0f", getArea(height, width));
    }

    private static double getArea(double height, double width) {
        return height * width;
    }
}
