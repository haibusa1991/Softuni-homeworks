package L07Generics.E04GenericSwapMethodInteger;

import L07Generics.Generics.Box;
import L07Generics.Generics.ListUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<Box<Integer>> boxes = new ArrayList<>();
        while (n-- > 0) {
            boxes.add(new Box<>(Integer.parseInt(scanner.nextLine())));
        }
        String[] tokens = scanner.nextLine().split(" ");
        int index1 = Integer.parseInt(tokens[0]);
        int index2 = Integer.parseInt(tokens[1]);
        ListUtils.swap(boxes, index1, index2);
        boxes.forEach(System.out::println);
    }
}
