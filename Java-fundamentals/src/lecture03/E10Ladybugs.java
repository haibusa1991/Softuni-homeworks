package lecture03;

import java.util.Arrays;
import java.util.Scanner;

public class E10Ladybugs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int fieldSize = Integer.parseInt(scanner.nextLine());
        int[] occupiedFields = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .limit(fieldSize)
                .toArray();

        int[] ladybugs = new int[fieldSize];
        for (int i = 0; i < occupiedFields.length; i++) {
            if (occupiedFields[i] >= 0 && occupiedFields[i] < ladybugs.length) {
                ladybugs[occupiedFields[i]] = 1;
            }
        }

        String input = scanner.nextLine();
        while (!input.equalsIgnoreCase("end")) {
            String[] commands = input.split(" ");
            int field = Integer.parseInt(commands[0]);
            boolean isMovingRight = commands[1].equalsIgnoreCase("right");
            int span = Integer.parseInt(commands[2]);

            if (field >= 0 && field < fieldSize && ladybugs[field] == 1) {
                ladybugs[field] = 0;

                int targetField;
                if (isMovingRight) {
                    targetField = field + span;
                } else {
                    targetField = field - span;
                }

                while (targetField >= 0
                        && targetField < fieldSize
                        && ladybugs[targetField] != 0) {
                    if (isMovingRight) {
                        targetField += span;
                    } else {
                        targetField -= span;
                    }
                }
                if (targetField >= 0 && targetField < fieldSize) {
                    ladybugs[targetField] = 1;
                }
            }
            input = scanner.nextLine();
        }
        for (int item : ladybugs) {
            System.out.print(item + " ");
        }
    }
}
