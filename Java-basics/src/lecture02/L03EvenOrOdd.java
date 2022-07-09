package lecture02;

import java.util.Scanner;

public class L03EvenOrOdd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int input = Integer.parseInt(sc.nextLine());

        if (input == ((input / 2) * 2)) {
            System.out.println("even");
        } else {
            System.out.println("odd");

        }
    }
}
