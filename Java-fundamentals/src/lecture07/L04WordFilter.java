package lecture07;

import java.util.Arrays;
import java.util.Scanner;

public class L04WordFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        Arrays.stream(input).filter(e -> e.length() % 2 == 0).forEach(System.out::println);
    }
}
