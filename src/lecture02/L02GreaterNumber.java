package lecture02;

import java.util.Scanner;

public class L02GreaterNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int val1 = Integer.parseInt(sc.nextLine());
        int val2 = Integer.parseInt(sc.nextLine());

        if (val1 > val2) {
            System.out.println(val1);
        } else {
            System.out.println(val2);
        }
    }
}
