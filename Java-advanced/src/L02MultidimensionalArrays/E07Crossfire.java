package L02MultidimensionalArrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class E07Crossfire {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[][] battlefield = populateMatrix(reader);

        String coordinates = reader.readLine();
        while (!coordinates.equals("Nuke it from orbit")) {
            battlefield = nuke(coordinates, battlefield);
            coordinates = reader.readLine();
        }
        printMatrix(battlefield);
    }

    private static int[][] populateMatrix(BufferedReader reader) throws IOException {
        int[] input = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int r = input[0];
        int c = input[1];

        int[][] matrix = new int[r][c];
        for (int i = 0; i < r; i++) {
            int finalI = i;
            Arrays.setAll(matrix[i], e -> finalI * c + e + 1);
        }
        return matrix;
    }

    private static int[][] nuke(String coordinates, int[][] matrix) {
        int[] input = Arrays.stream(coordinates.split(" ")).mapToInt(Integer::parseInt).toArray();
        int r = input[0];
        int c = input[1];
        int radius = input[2];
        int startRow = r - radius;
        int endRow = r + radius;
        int startColumn = c - radius;
        int endColumn = c + radius;

        for (int i = startRow; i <= endRow; i++) {
            if (isValidIndex(i, c, matrix)) {
                matrix[i][c] = 0;
            }
        }

        for (int i = startColumn; i <= endColumn; i++) {
            if(isValidIndex(r,i,matrix)) {
                matrix[r][i] = 0;
            }
        }
        return removeZeroes(matrix);
    }

    private static boolean isValidIndex(int i, int c, int[][] matrix) {
        if (i < 0 || i >= matrix.length) {
            return false;
        }

        return c >= 0 && c < matrix[i].length;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    private static int[][] removeZeroes(int[][] matrix) {
        int r = getRowsAfterNuke(matrix);
        int[][] nukedMatrix = new int[r][];
        int rowOffset = 0;
        for (int i = 0; i < nukedMatrix.length; i++) {
            if (isZeroRow(matrix[i])) {
                rowOffset++;
            }
            int c = getColumnsAfterNuke(matrix[i + rowOffset]);
            nukedMatrix[i] = new int[c];
        }

        rowOffset = 0;
        for (int i = 0; i < nukedMatrix.length; i++) {
            if (isZeroRow(matrix[i])) {
                rowOffset++;
            }
            int columnOffset = 0;
            for (int j = 0; j < nukedMatrix[i].length; j++) {
                int currentValue = matrix[i + rowOffset][j + columnOffset];
                while (currentValue == 0) {
                    columnOffset++;
                    currentValue = matrix[i + rowOffset][j + columnOffset];
                }
                nukedMatrix[i][j] = currentValue;
            }
        }

        return nukedMatrix;
    }

    private static int getColumnsAfterNuke(int[] matrix) {
        int c = 0;
        for (int value : matrix) {
            if (value != 0) {
                c++;
            }
        }
        return c;
    }

    private static boolean isZeroRow(int[] row) {
        int numZeroes = 0;
        for (int value : row) {
            if (value == 0) {
                numZeroes++;
            }
        }
        return numZeroes == row.length;
    }

    private static int getRowsAfterNuke(int[][] matrix) {
        int r = 0;
        for (int[] row : matrix) {
            if (!isZeroRow(row)) {
                r++;
            }
        }
        return r;
    }
}