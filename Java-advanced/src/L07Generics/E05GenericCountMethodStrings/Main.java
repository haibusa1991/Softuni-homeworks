package L07Generics.E05GenericCountMethodStrings;

import L07Generics.Generics.Box;
import L07Generics.Generics.ListUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<Box<String>> boxes = new ArrayList<>();
        while (n-- > 0) {
            boxes.add(new Box<>(scanner.nextLine()));
        }

        Box<String> target = new Box<>(scanner.nextLine());
        System.out.println(ListUtils.greaterThan(boxes,target));
    }
}