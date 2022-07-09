package L02MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class E03DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int sum1 = 0;
        for (int i = 0; i < n; i++) {
            sum1 += matrix[i][i];
        }
        int sum2=0;
        for (int i = 0; i < n; i++) {
            sum2 += matrix[i][n - i - 1];
        }
        System.out.println(Math.abs(sum1-sum2));
    }
}
