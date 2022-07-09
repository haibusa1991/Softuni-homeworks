package Exam2;

import java.util.Scanner;

public class T04GiftsFromSanta {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rangeStart = Integer.parseInt(scanner.nextLine());
        int rangeEnd = Integer.parseInt(scanner.nextLine());
        int target = Integer.parseInt(scanner.nextLine());

        for (int i = rangeEnd; i >= rangeStart; i--) {
            if (i % 2 == 0 && i % 3 == 0) {
                if (i == target) {
                    break;
                }
                System.out.print(i + " ");
            }
        }

    }
}
