package L02MultidimensionalArrays;

import java.util.Scanner;

public class E02MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int r = scanner.nextInt();
        int c = scanner.nextInt();
        String[][] matrix = new String[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                matrix[i][j] = getPalindrome(i, j);
            }
        }
        printMatrix(matrix);
    }

    private static String getPalindrome(int r, int c) {
        return "" + (char) (r + 97) + (char) (r + c + 97) + (char) (r + 97);
    }

    public static void printMatrix(String[][] matrix) {
        for (String[] row : matrix) {
            for (String value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

}
