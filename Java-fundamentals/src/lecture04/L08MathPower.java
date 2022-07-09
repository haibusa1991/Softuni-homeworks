package lecture04;

import java.text.DecimalFormat;
import java.util.Scanner;

public class L08MathPower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double base = Double.parseDouble(scanner.nextLine());
        double power = Double.parseDouble(scanner.nextLine());
        DecimalFormat df = new DecimalFormat("0.####");
        System.out.println(df.format(getPower(base, power)));
    }

    static double getPower(double a, double b) {
        return Math.pow(a, b);
    }
}
