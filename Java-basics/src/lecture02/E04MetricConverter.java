package lecture02;

import java.util.Scanner;

public class E04MetricConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double inputValue = Double.parseDouble(sc.nextLine());
        String inputUnit = sc.nextLine();
        String outputUnit = sc.nextLine();

        if (inputUnit.equals("cm")) {
            inputValue *= 10;
        } else if (inputUnit.equals("m")) {
            inputValue *= 1000;
        }

        if (outputUnit.equals("cm")) {
            inputValue /= 10;
        } else if (outputUnit.equals("m")) {
            inputValue /= 1000;
        }

        System.out.printf("%.3f", inputValue);
    }
}
