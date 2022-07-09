package L07Generics.E08CustomListSorter;

import L07Generics.Generics.CustomList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        CustomList<String> list = new CustomList<>();
        while (!input.equals("END")) {
            String[] tokens = input.split(" ");
            switch (tokens[0]) {
                case "Add":
                    list.add(tokens[1]);
                    break;
                case "Remove":
                    list.remove(Integer.parseInt(tokens[1]));
                    break;
                case "Contains":
                    System.out.println(list.contains(tokens[1]));
                    break;
                case "Swap":
                    int index1 = Integer.parseInt(tokens[1]);
                    int index2 = Integer.parseInt(tokens[2]);
                    list.swap(index1, index2);
                    break;
                case "Greater":
                    System.out.println(list.greaterThan(tokens[1]));
                    break;
                case "Max":
                    System.out.println(list.getMax());
                    break;
                case "Min":
                    System.out.println(list.getMin());
                    break;
                case "Print":
                    list.printAll();
                    break;
                case "Sort":
                    list.sort();
            }
            input = scanner.nextLine();
        }
    }
}
