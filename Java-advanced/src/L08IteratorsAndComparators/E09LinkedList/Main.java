package L08IteratorsAndComparators.E09LinkedList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split(" ");
            String command = tokens[0];
            int value = Integer.parseInt(tokens[1]);
            switch (command) {
                case "Add":
                    linkedList.add(value);
                    break;
                case "Remove":
                    linkedList.remove(value);
                    break;
            }
        }
        System.out.println(linkedList.getSize());
        linkedList.forEach(e -> System.out.print(e + " "));
    }
}
