package FinalExam;

import java.util.Arrays;
import java.util.Scanner;

public class MouseAndCheese {
    static char[][] territory;
    static int r;
    static int c;
    static int numCheeses = 0;
    static boolean hasGoneOut = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        territory = new char[n][];
        for (int i = 0; i < n; i++) {
            char[] input = scanner.nextLine().toCharArray();
            for (int j = 0; j < input.length; j++) {
                if (input[j] == 'M') {
                    r = i;
                    c = j;
                    input[j] = '-';
                }
                territory[i] = input;
            }
        }

        String direction = scanner.nextLine();
        while (!direction.equals("end")) {
            move(direction);
            evaluateCell(direction);

            if (hasGoneOut) {
                break;
            }
            direction = scanner.nextLine();
        }

        if (hasGoneOut) {
            System.out.println("Where is the mouse?");
        }

        String result = numCheeses < 5
                ? String.format("The mouse couldn't eat the cheeses, she needed %d cheeses more.", 5 - numCheeses)
                : String.format("Great job, the mouse is fed %d cheeses!", numCheeses);
        System.out.println(result);
        printTerritory();
    }

    private static void move(String direction) {
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
    }

    private static void evaluateCell(String direction) {
        if (r < 0
                || r == territory.length
                || c < 0
                || c == territory.length) {
            hasGoneOut = true;
        } else if (territory[r][c] == 'c') {
            numCheeses++;
            territory[r][c] = '-';
        } else if (territory[r][c] == 'B') {
            territory[r][c] = '-';
            move(direction);
            evaluateCell(direction);
        }

    }

    private static void printTerritory(){
        if(!hasGoneOut){
            territory[r][c] = 'M';
        }
        for (char[] chars : territory) {
            System.out.println(Arrays.toString(chars).replaceAll("[\\[\\], ]",""));
        }
    }
}
