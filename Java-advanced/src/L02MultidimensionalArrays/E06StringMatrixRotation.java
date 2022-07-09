package L02MultidimensionalArrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E06StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String rotation = scanner.nextLine();
        int degrees = Integer.parseInt(rotation.substring(rotation.indexOf('(') + 1, rotation.indexOf(')'))) % 360;
        List<String> strings = new ArrayList<>();
        String input = scanner.nextLine();
        while (!input.equals("END")) {
            strings.add(input);
            input = scanner.nextLine();
        }
        String[][] matrix = populateMatrix(strings);
        switch (degrees) {
            case 0:
                break;
            case 90:
                matrix = rotate90(matrix);
                break;
            case 180:
                matrix = rotate180(matrix);
                break;
            case 270:
                matrix = rotate270(matrix);
                break;
        }
        printMatrix(matrix);
    }

    public static void printMatrix(String[][] matrix) {
        for (String[] row : matrix) {
            for (String value : row) {
                System.out.print(value + "");
            }
            System.out.println();
        }
    }

    private static String[][] populateMatrix(List<String> strings) {

        int r = strings.size();
        int c = 0;
        for (String s : strings) {
            if (s.length() > c) {
                c = s.length();
            }
        }

        for (int i = 0; i < strings.size(); i++) {
            StringBuilder sb = new StringBuilder(strings.get(0));
            while (sb.length() < c) {
                sb.append(" ");
            }
            strings.remove(0);
            strings.add(sb.toString());
        }

        String[][] matrix = new String[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                matrix[i][j] = strings.get(i).charAt(j) + "";
            }
        }
        return matrix;
    }

    private static String[][] rotate90(String[][] matrix) {
        //matrix [r1][c1]
        //newMatrix [r2][c2]
        int r1 = matrix.length;
        int c1 = matrix[0].length;
        int r2 = matrix[0].length;
        int c2 = matrix.length;
        String[][] newMatrix = new String[r2][c2];
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c1; j++) {
                newMatrix[j][i] = matrix[r1 - i - 1][j];
            }
        }
        return newMatrix;
    }

    private static String[][] rotate180(String[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        String[][] newMatrix = new String[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                newMatrix[i][j] = matrix[r - 1 - i][c - 1 - j];
            }
        }
        return newMatrix;
    }

    private static String[][] rotate270(String[][] matrix) {
        //matrix [r1][c1]
        //newMatrix [r2][c2]
        int r1 = matrix.length;
        int c1 = matrix[0].length;
        int r2 = matrix[0].length;
        int c2 = matrix.length;
        String[][] newMatrix = new String[r2][c2];
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c1; j++) {
                newMatrix[j][i] = matrix[i][c1 - j - 1];
            }
        }
        return newMatrix;
    }
}
