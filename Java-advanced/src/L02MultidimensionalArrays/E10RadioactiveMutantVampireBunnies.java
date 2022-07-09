package L02MultidimensionalArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class E10RadioactiveMutantVampireBunnies {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int r = dimensions[0];
        int c = dimensions[1];
        char[][] field = new char[r][c];
        int[] playerLocation = new int[]{0, 0};
        for (int i = 0; i < r; i++) {
            String row = scanner.nextLine();
            for (int j = 0; j < row.length(); j++) {
                field[i][j] = row.charAt(j);
                if (field[i][j] == 'P') {
                    playerLocation = new int[]{i, j};
                    field[i][j] = '.';
                }
            }
        }

        char[] movements = scanner.nextLine().toCharArray();
        List<int[]> bunniesToMultiply = new ArrayList<>();
        boolean hasDied = false;
        boolean hasEscaped = false;
        int[] lastPlayerLocation = {};
        for (int i = 0; i < movements.length; i++) {
            if (field[playerLocation[0]][playerLocation[1]] == 'B') {
                hasDied = true;
                lastPlayerLocation = playerLocation;
                break;
            }
            bunniesToMultiply = getOriginalBunnies(field);
            char currentDirection = movements[i];
            lastPlayerLocation = playerLocation;
            playerLocation = movePlayer(currentDirection, playerLocation);
            if (playerLocation[0] < 0
                    || playerLocation[0] >= r
                    || playerLocation[1] < 0
                    || playerLocation[1] >= c) {
                hasEscaped = true;
            }
            if (!hasEscaped && field[playerLocation[0]][playerLocation[1]] == 'B') {
                lastPlayerLocation = playerLocation;
                hasDied = true;
            }
            field = multiplyBunnies(bunniesToMultiply, field);
            if (hasDied || hasEscaped) {
                break;
            }
        }
        printMatrix(field);
        System.out.print(hasDied ? "dead: " : "won: ");
        System.out.print("" + lastPlayerLocation[0] + " " + lastPlayerLocation[1]);
    }

    private static char[][] multiplyBunnies(List<int[]> bunnies, char[][] field) {
        for (int[] bunny : bunnies) {
            int r = bunny[0];
            int c = bunny[1];
            if (isValidIndex(r - 1, c, field)) { //up
                field[r - 1][c] = 'B';
            }
            if (isValidIndex(r, c + 1, field)) { //right
                field[r][c + 1] = 'B';
            }
            if (isValidIndex(r + 1, c, field)) { //down
                field[r + 1][c] = 'B';
            }
            if (isValidIndex(r, c - 1, field)) { //left
                field[r][c - 1] = 'B';
            }
        }
        return field;
    }

    private static boolean isValidIndex(int r, int c, char[][] field) {
        return !(r < 0
                || r > field.length - 1
                || c < 0
                || c > field[r].length - 1);
    }

    private static int[] movePlayer(char currentDirection, int[] currentLocation) {
        switch (currentDirection) {
            case 'U':
                return new int[]{currentLocation[0] - 1, currentLocation[1]};
            case 'D':
                return new int[]{currentLocation[0] + 1, currentLocation[1]};
            case 'L':
                return new int[]{currentLocation[0], currentLocation[1] - 1};
            case 'R':
                return new int[]{currentLocation[0], currentLocation[1] + 1};
        }
        return null;
    }

    private static List<int[]> getOriginalBunnies(char[][] field) {
        List<int[]> output = new ArrayList<>();
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == 'B') {
                    output.add(new int[]{i, j});
                }
            }
        }
        return output;
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
