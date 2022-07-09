package lecture01;

import java.util.Scanner;

public class ME01SortNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());
        int num3 = Integer.parseInt(scanner.nextLine());

        int max = Math.max(Math.max(num1, num2), num3);
        int min = Math.min(Math.min(num1, num2), num3);
        int mid = num1 + num2 + num3 - max - min;

        System.out.println(max);
        System.out.println(mid);
        System.out.println(min);

    }
}

