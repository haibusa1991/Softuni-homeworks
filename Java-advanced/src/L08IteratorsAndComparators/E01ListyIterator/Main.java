package L08IteratorsAndComparators.E01ListyIterator;

import L08IteratorsAndComparators.Iterators.ListyIterator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tokens = scanner.nextLine().split(" ");
        ListyIterator list = new ListyIterator(Arrays.copyOfRange(tokens, 1, tokens.length));


        String input = scanner.nextLine();
        while (!input.equals("END")) {
            switch (input) {
                case "Move":
                    System.out.println(list.move());
                    break;
                case "Print":
                    try {
                        list.print();
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "HasNext":
                    System.out.println(list.hasNext());
                    break;
            }
            input = scanner.nextLine();
        }

    }
}
