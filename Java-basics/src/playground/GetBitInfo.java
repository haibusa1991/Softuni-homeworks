package playground;

import java.util.Scanner;

public class GetBitInfo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int input =0;
            try {
                input = Integer.parseInt(sc.nextLine());
            }catch (Exception e){
                input = Integer.MAX_VALUE;
                System.out.println("Invalid input, using value=" + Integer.MAX_VALUE);
            }
            long timer = System.nanoTime();

            System.out.println("isEvenMod: " + isEvenMod(input) + (System.nanoTime() - timer) + " ns");
            timer = System.nanoTime();
            System.out.println("isEvenBit: " + isEvenMod(input) + (System.nanoTime() - timer) + " ns");
            timer = System.nanoTime();
            System.out.println("isEvenDiv: " + isEvenMod(input) + (System.nanoTime() - timer) + " ns");
        }
    }

    public static boolean isEvenMod(int value) {
        return value % 2 == 0;
    }

    public static boolean isEvenDiv(int value) {
        return value == (value / 2) * 2;
    }

    public static boolean isEvenBits(int value) {

//        return Integer.lowestOneBit(value) != 1;
        value <<=31;
        value >>=31;
        return value==0;

    }
}
