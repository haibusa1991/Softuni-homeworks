package midExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Problem02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!input.equals("Finish")) {
            String[] data = input.split(" ");
            String command = data[0];
            int value = Integer.parseInt(data[1]);

            switch (command) {
                case "Add":
                    numbers.add(value);
                    break;
                case "Remove":
                    numbers.remove(Integer.valueOf(value));
                    break;
                case "Replace":
                    for (int i = 0; i < numbers.size(); i++) {
                        if (numbers.get(i) == value) {
                            numbers.set(i, Integer.parseInt(data[2]));
                            break;
                        }
                    }
                    break;
                case "Collapse":
                    List<Integer> numbersToRemove = numbers
                            .stream().filter(e -> value > e)
                            .collect(Collectors.toList());
                    for (int number : numbersToRemove) {
                        numbers.remove(Integer.valueOf(number));
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
    }
}
