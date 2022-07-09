package L02MultidimensionalArrays;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class E12TheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] tokens = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        char[][] matrix = new char[tokens[0]][];
        for (int i = 0; i < tokens[0]; i++) {
            matrix[i] = scanner.nextLine().replace(" ", "").toCharArray();
        }
        char floodChar = scanner.nextLine().charAt(0);
        int[] floodStart = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int startR = floodStart[0];
        int startC = floodStart[1];
        char replaceChar = matrix[startR][startC];
        matrix[startR][startC] = floodChar;

        ArrayDeque<int[]> floodingChars = new ArrayDeque<>();
        floodingChars.offer(new int[]{startR, startC});

        while (!floodingChars.isEmpty()) {
            int[] currentChar = floodingChars.poll();
            int r = currentChar[0];
            int c = currentChar[1];

            //up flood
            {
                int r1 = r - 1;
                int c1 = c;
                if (isValid(r1, c1, matrix) && matrix[r1][c1] == replaceChar) {
                    matrix[r1][c1] = floodChar;
                    floodingChars.offer(new int[]{r1, c1});
                }
            }
            //right flood
            {
                int r1 = r;
                int c1 = c + 1;
                if (isValid(r1, c1, matrix) && matrix[r1][c1] == replaceChar) {
                    matrix[r1][c1] = floodChar;
                    floodingChars.offer(new int[]{r1, c1});
                }
            }
            //down flood
            {
                int r1 = r + 1;
                int c1 = c;
                if (isValid(r1, c1, matrix) && matrix[r1][c1] == replaceChar) {
                    matrix[r1][c1] = floodChar;
                    floodingChars.offer(new int[]{r1, c1});
                }
            }
            //left flood
            {
                int r1 = r;
                int c1 = c - 1;
                if (isValid(r1, c1, matrix) && matrix[r1][c1] == replaceChar) {
                    matrix[r1][c1] = floodChar;
                    floodingChars.offer(new int[]{r1, c1});
                }
            }
        }
        printMatrix(matrix);
    }

    private static boolean isValid(int r, int c, char[][] matrix) {
        return !(r < 0
                || r > matrix.length - 1
                || c < 0
                || c > matrix[r].length - 1);
    }

    public static void printMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            for (char value : row) {
                System.out.print(value + "");
            }
            System.out.println();
        }
    }
}
