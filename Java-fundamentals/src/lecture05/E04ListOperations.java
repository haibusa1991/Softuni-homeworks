package lecture05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E04ListOperations {
    static List<Integer> input = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        input = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scanner.nextLine();
        while (!command.equalsIgnoreCase("end")) {

            dispatcher(command);
            command = scanner.nextLine();
        }
        scanner.close();
        System.out.println(input.toString().replaceAll("[\\[\\],]", ""));
    }

    public static void dispatcher(String s) {
        String[] command = s.split(" ");

        switch (command[0]) {
            case "Add":
                input.add(Integer.parseInt(command[1]));
                break;
            case "Insert":
                int index = Integer.parseInt(command[2]);
                if (index > input.size() - 1 || index < 0) {
                    System.out.println("Invalid index");
                    return;
                }
                input.add(Integer.parseInt(command[2]), Integer.parseInt(command[1]));
                break;
            case "Remove":
                index = Integer.parseInt(command[1]);
                if (index > input.size() - 1 || index < 0) {
                    System.out.println("Invalid index");
                    return;
                }
                input.remove(Integer.parseInt(command[1]));
                break;
            case "Shift":
                shift(Integer.parseInt(command[2]), command[1].equalsIgnoreCase("right"));
                break;
        }
    }

    public static void shift(int shift, boolean isRightShift) {

        List<Integer> shiftedList = new ArrayList<>();
        if (isRightShift) {
            for (int i = 0; i < input.size(); i++) {
                shiftedList.add((input.get((input.size() - shift % input.size() + i) % (input.size()))));
            }
        } else {
            for (int i = 0; i < input.size(); i++) {
                shiftedList.add((input.get((input.size() + shift + i) % (input.size()))));
            }
        }

        input = shiftedList;
    }

}
