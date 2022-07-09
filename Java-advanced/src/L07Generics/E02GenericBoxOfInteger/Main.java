package L07Generics.E02GenericBoxOfInteger;

import L07Generics.Generics.Box;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            Box<Integer> box = new Box<>(Integer.parseInt(scanner.nextLine()));
            System.out.println(box);
        }
    }
}
