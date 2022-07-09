package playground;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class FindPrimesToN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //int n = Integer.parseInt(scanner.nextLine());

//        FindPrimesBruteForce(n);
//        System.out.println();
//        FindPrimesOptimized1(n);
        FindPrimesOptimized1(150000);
    }

    public static void FindPrimesBruteForce(int n) {

        List<Integer> primes = new ArrayList<>();

        long timer = System.nanoTime();
        boolean isPrime = true;

        for (int i = 2; i <= n; i++) {
            for (int j = 2; j < i - 1; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                primes.add(i);
            }
            isPrime = true;
        }
        long time = System.nanoTime() - timer;
        System.out.printf("Num of primes: %d\nRuntime: %d ns", primes.size(), time);
    }

    public static void FindPrimesOptimized1(int n) {

        List<Integer> primes = new ArrayList<>();
        primes.add(2);

        long timer = System.currentTimeMillis();
        boolean isPrime = true;

        for (int i = 3; i <= n; i++) {
            for (int value : primes) {

                if ((i / 2) * 2 == i) {
                    isPrime = false;
                    break;
                }

                if (value * 2 > i) {
                    break;
                }

                if (i % value == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                primes.add(i);
            }
            isPrime = true;
        }
        long time = System.currentTimeMillis() - timer;
        System.out.printf("Num of primes: %d\nRuntime: %d ms", primes.size(), time);
    }

}