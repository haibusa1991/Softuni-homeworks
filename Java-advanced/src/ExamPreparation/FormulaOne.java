package ExamPreparation;

import java.util.Arrays;
import java.util.Scanner;

public class FormulaOne {
    static int r = 0;
    static int c = 0;
    static int rF = 0;
    static int cF = 0;
    static char[][] track;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        track = new char[n][];
        int m = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            if (input.contains("P")) {
                r = i;
                c = input.indexOf('P');
                input = input.replace('P', '.');
            }
            if (input.contains("F")) {
                rF = i;
                cF = input.indexOf('F');
            }
            track[i] = input.toCharArray();
        }

        while (m-- > 0) {
            movePlayer(scanner.nextLine());
            if (r == rF && c == cF) {
                break;
            }
        }
        if (r == rF && c == cF) {
            System.out.println("Well done, the player won first place!");
        } else {
            System.out.println("Oh no, the player got lost on the track!");
        }

        track[r][c] = 'P';
        for (char[] row : track) {
            System.out.println(Arrays.toString(row).replaceAll("[\\[\\], ]", ""));
        }
    }

    private static void movePlayer(String direction) {
        switch (direction) {
            case "up":
                r--;
                break;
            case "right":
                c++;
                break;
            case "down":
                r++;
                break;
            case "left":
                c--;
                break;
        }
        updateLocation(direction);
    }

    private static void updateLocation(String direction) {
        if (r < 0) {
            r = track.length - 1;
        }
        if (r == track.length) {
            r = 0;
        }
        if (c < 0) {
            c = track.length - 1;
        }
        if (c == track.length) {
            c = 0;
        }
        if (track[r][c] == 'B') {
            movePlayer(direction);
        }
        if (track[r][c] == 'T') {
            movePlayer(reverse(direction));
        }
    }

    private static String reverse(String direction) {

        switch (direction) {
            case "up":
                return "down";
            case "right":
                return "left";
            case "down":
                return "up";
            case "left":
                return "right";
        }
        return "";
    }
}
