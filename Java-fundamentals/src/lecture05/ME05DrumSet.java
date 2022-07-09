package lecture05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ME05DrumSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double savings = Double.parseDouble(scanner.nextLine());
        List<Integer> originalDrums = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> drums = new ArrayList<>(originalDrums);

        String input = scanner.nextLine();
        while (!input.equalsIgnoreCase("Hit it again, Gabsy!")) {
            int hitPower = Integer.parseInt(input);

            for (int i = 0; i < drums.size(); i++) {

                if (drums.get(i) != Integer.MIN_VALUE) {
                    drums.set(i, drums.get(i) - hitPower);
                }

                if (drums.get(i) <= 0 && drums.get(i) != Integer.MIN_VALUE) {
                    int price = originalDrums.get(i) * 3;
                    if (price <= savings) {
                        savings -= price;
                        drums.set(i, originalDrums.get(i));
                    } else {
                        drums.set(i, Integer.MIN_VALUE);
                    }
                }
            }

            input = scanner.nextLine();
        }
        while (drums.contains(Integer.MIN_VALUE)) {
            drums.remove(Integer.valueOf(Integer.MIN_VALUE));
        }
        System.out.println(drums.toString().replaceAll("[\\[\\],]", ""));
        System.out.printf("Gabsy has %.2flv.", savings);
    }
}
