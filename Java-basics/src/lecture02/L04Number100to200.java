package lecture02;

import java.util.Scanner;

public class L04Number100to200 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = Integer.parseInt(sc.nextLine());

        if (input < 100) {
            System.out.println("Less than 100");
        } else if (input <= 200) {
            System.out.println("Between 100 and 200");
        } else {
            System.out.println("Greater than 200");
        }
    }
}
