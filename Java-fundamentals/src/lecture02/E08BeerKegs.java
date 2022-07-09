package lecture02;

import java.util.Scanner;

public class E08BeerKegs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        String largestKeg = "";
        double largestVolume = 0;

        for (int i = 0; i < n; i++) {
            String model = scanner.nextLine();
            double radius = Double.parseDouble(scanner.nextLine());
            int height = Integer.parseInt(scanner.nextLine());

            double currentVolume = Math.PI * radius * radius * height;
            if (currentVolume > largestVolume) {
                largestVolume = currentVolume;
                largestKeg = model;
            }
        }
        System.out.println(largestKeg);
    }
}
