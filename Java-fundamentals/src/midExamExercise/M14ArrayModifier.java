package midExamExercise;
//https://judge.softuni.bg/Contests/Practice/Index/2474#1

import java.util.Arrays;
import java.util.Scanner;

public class M14ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] data = input.split(" ");
            String command = data[0];
            int index1 = 0;
            int index2 = 0;
            if (data.length > 1) {
                index1 = Integer.parseInt(data[1]);
                index2 = Integer.parseInt(data[2]);
            }
            switch (command) {
                case "swap":
                    numbers[index1] = numbers[index1] + numbers[index2];
                    numbers[index2] = numbers[index1] - numbers[index2];
                    numbers[index1] = numbers[index1] - numbers[index2];
                    break;
                case "multiply":
                    numbers[index1] *= numbers[index2];
                    break;
                case "decrease":
                    for (int i = 0; i < numbers.length; i++) {
                        numbers[i]--;
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println(Arrays.toString(numbers).replaceAll("[\\[\\]]", ""));

    }
}
