package lecture05;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class L04ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> input = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scanner.nextLine();
        while (!command.equalsIgnoreCase("end")) {
            String[] values = command.split(" ");
            int n1 = Integer.parseInt(values[1]);
            int n2 = 0;
            if (values.length == 3) {
                n2 = Integer.parseInt(values[2]);
            }
            if (command.contains("Add")) {
                input.add(n1);
            } else if (command.contains("Remove ")) {
                input.remove(Integer.valueOf(n1));
            } else if (command.contains("RemoveAt")) {
                input.remove(n1);
            } else if (command.contains("Insert")) {
                input.add(n2, n1);
            }
            command = scanner.nextLine();
        }
        System.out.println(input.toString().replaceAll("[\\[\\],]", ""));
    }
}
