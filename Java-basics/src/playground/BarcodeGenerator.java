package playground;
//https://judge.softuni.bg/Contests/Practice/DownloadResource/12462
//https://judge.softuni.bg/Contests/Practice/Index/2507#5

import java.util.Scanner;

public class BarcodeGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lowerBound = Integer.parseInt(sc.nextLine());
        int upperBound = Integer.parseInt(sc.nextLine());
        ifFunction(lowerBound, upperBound);
//        int num = Integer.parseInt(sc.nextLine());
//        while (true) {
//            System.out.println(getDigitAt(num, Integer.parseInt(sc.nextLine())));
//        }

    }

    public static void ifFunction(int lowerBound, int upperBound) {
//         long startTimer = System.currentTimeMillis();
        final int lowerBoundI = getDigitAt(lowerBound, 0);
        final int upperBoundI = getDigitAt(upperBound, 0);
        final int lowerBoundJ = getDigitAt(lowerBound, 1);
        final int upperBoundJ = getDigitAt(upperBound, 1);
        final int lowerBoundK = getDigitAt(lowerBound, 2);
        final int upperBoundK = getDigitAt(upperBound, 2);
        final int lowerBoundM = getDigitAt(lowerBound, 2);
        final int upperBoundM = getDigitAt(upperBound, 2);


        for (int i = lowerBoundI; i <= upperBoundI; i += 2) {
            if (isEven(lowerBoundI) && lowerBoundI == i) {
                i--;
                continue;
            }
            for (int j = lowerBoundJ; j <= upperBoundJ; j += 2) {
                if (isEven(lowerBoundJ) && lowerBoundJ == j) {
                    j--;
                    continue;
                }
                for (int k = lowerBoundK; k <= upperBoundK; k += 2) {
                    if (isEven(lowerBoundK) && lowerBoundK == k) {
                        k--;
                        continue;
                    }
                    for (int m = lowerBoundM; m <= upperBoundM; m += 2) {
                        if (isEven(lowerBoundM) && lowerBoundM == m) {
                            m--;
                            continue;
                        }
                        System.out.print(i);
                        System.out.print(j);
                        System.out.print(k);
                        System.out.print(m);
                        System.out.print(" ");
                    }
                }
            }
        }

        //return ("\n"+(System.currentTimeMillis() - startTimer) + "ms");
//        System.out.println(("\n"+(System.currentTimeMillis() - startTimer) + "ms"));
    }

//    public static boolean isEven(int value) {
//        return value == (value / 2) * 2;
//    }

    public static boolean isEven(int value) {

        value <<=31;
        value >>=31;
        return value==0;

    }

    public static int getDigitAt(int value, int pos) {
        int numberOfDigits = 1;
        int valueIterator = value;
        if (valueIterator < 0) {
            valueIterator *= -1;
        }
        while (valueIterator >= 10) {
            valueIterator /= 10;
            numberOfDigits++;
        }

        if (pos >= numberOfDigits || pos < 0) {
            return Integer.MAX_VALUE;
        }

        int divA = (int) Math.pow(10, numberOfDigits - pos);
        int divB = divA / 10;
        return (value - ((value / divA) * divA)) / divB;


    }
}

