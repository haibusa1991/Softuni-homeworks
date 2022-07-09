package lecture04;

import java.util.Scanner;

public class L03NumbersOneToNWithStepThree {
    public static void main(String[] args) {
        Scanner scanner = new  Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <=input ; i+=3) {
            System.out.println(i);
        }
    }
}
