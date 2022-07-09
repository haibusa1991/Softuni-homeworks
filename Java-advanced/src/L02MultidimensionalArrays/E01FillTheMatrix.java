package L02MultidimensionalArrays;

import java.util.Scanner;

public class E01FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(", ");
        int n = Integer.parseInt(input[0]);
        int[][] matrix = new int[n][n];
        int currentValue = 1;
        if (input[1].equals("A")) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[j][i] = currentValue;
                    currentValue++;
                }
            }
        } else {
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    for (int j = 0; j < n; j++) {
                        matrix[j][i] = currentValue;
                        currentValue++;
                    }
                } else {
                    for (int j = n-1; j >=0 ; j--) {
                        matrix[j][i]=currentValue;
                        currentValue++;
                    }
                }
            }
        }
        printMatrix(matrix);
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
