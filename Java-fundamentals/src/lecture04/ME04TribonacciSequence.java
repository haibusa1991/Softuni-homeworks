package lecture04;

import java.util.Scanner;

public class ME04TribonacciSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        System.out.print(getTribonacci(num));
    }

//    private static int getTribonacci(int n) {
//        if (n == 1 || n == 2) {
//            return 1;
//        }
//        if (n == 3) {
//            return 2;
//        }
//
//        return getTribonacci(n - 3) + getTribonacci(n - 2) + getTribonacci(n - 1);
//
//    }

    private static String getTribonacci(int n) {
        if (n == 1) {
            return "1";
        }
        if (n == 2) {
            return "1 1";
        }
        if (n == 3) {
            return "1 1 2";
        }

        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i < n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3];

        }
        String output = "";
        for (int num : arr) {
            output += num + " ";
        }

        return output;
    }
}
