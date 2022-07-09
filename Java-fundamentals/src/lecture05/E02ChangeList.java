package lecture05;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E02ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> elements = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scanner.nextLine();
        while (!command.equalsIgnoreCase("end")) {

            manipulator(elements, command);

            command = scanner.nextLine();
        }
        System.out.println(elements.toString().replaceAll("[\\[\\],]", ""));
    }

    public static void manipulator(List<Integer> list, String s) {
        String[] command = s.split(" ");
        int elementValue = Integer.parseInt(command[1]);
        int elementIndex = 0;
        if (command.length == 3) {
            elementIndex = Integer.parseInt(command[2]);
        }

        switch (command[0]) {
            case "Delete": {
                while (list.contains(elementValue)) {
                    list.remove(Integer.valueOf(elementValue));
                }
                break;
            }
            case "Insert": {
                list.add(elementIndex, elementValue);
                break;
            }
        }
    }
}
