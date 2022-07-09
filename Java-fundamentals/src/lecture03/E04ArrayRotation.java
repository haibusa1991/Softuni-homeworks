package lecture03;

import java.util.Arrays;
import java.util.Scanner;

public class E04ArrayRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int shift = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[(i + shift) % input.length] + " ");
        }
    }
}
