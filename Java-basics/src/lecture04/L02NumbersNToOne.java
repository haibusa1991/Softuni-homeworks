package lecture04;

import java.util.Scanner;

public class L02NumbersNToOne {
    public static void main(String[] args) {
        Scanner scanner = new  Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());

        for (int i = input; i >0 ; i--) {
            System.out.println(i);
        }
    }
}
