package lecture05;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class L05ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> values = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scanner.nextLine();
        while (!command.equalsIgnoreCase("end")) {
            dispatcher(command, values);
            command = scanner.nextLine();
        }
    }

    public static void dispatcher(String s, List<Integer> list) {
        String[] command = s.split(" ");

        switch (command[0]) {
            case "Contains":
                printContains(list, command[1]);
                break;
            case "Print":
                if (command[1].equalsIgnoreCase("even")) {
                    printEven(list);
                } else {
                    printOdd(list);
                }
                break;
            case "Get":
                printSum(list);
                break;
            case "Filter":
                printFilter(list, command[1], command[2]);
                break;
        }
    }

    public static void printContains(List<Integer> list, String number) {
        int n = Integer.parseInt(number);
        if (list.contains(n)) {
            System.out.println("Yes");
        } else {
            System.out.println("No such number");
        }
    }

    public static void printEven(List<Integer> list) {
        for (int e : list) {
            if (e % 2 == 0)
                System.out.print(e + " ");
        }
        System.out.println();
    }

    public static void printOdd(List<Integer> list) {
        for (int e : list) {
            if (e % 2 != 0)
                System.out.print(e + " ");
        }
        System.out.println();
    }

    public static void printSum(List<Integer> list) {
        Integer[] arr = list.toArray(new Integer[0]);
        System.out.println(Arrays.stream(arr)
                .mapToInt(Integer::intValue)
                .sum());
    }

    public static void printFilter(List<Integer> list, String scope, String value) {
        int val = Integer.parseInt(value);

        switch (scope) {
            case "<=":
                for (int e : list) {
                    if (e <= val) {
                        System.out.print(e + " ");
                    }
                }
                break;
            case "<":
                for (int e : list) {
                    if (e < val) {
                        System.out.print(e + " ");
                    }
                }
                break;
            case ">=":
                for (int e : list) {
                    if (e >= val) {
                        System.out.print(e + " ");
                    }
                }
                break;
            case ">":
                for (int e : list) {
                    if (e > val) {
                        System.out.print(e + " ");
                    }
                }
                break;
        }
        System.out.println();
    }
}
