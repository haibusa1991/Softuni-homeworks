package ExamPreparation;

import java.util.Arrays;
import java.util.Scanner;

public class CookingJourney {
    static char[][] pastry;
    static int r = -1;
    static int c = -1;
    static int rP1 = -1;
    static int cP1 = -1;
    static int rP2 = -1;
    static int cP2 = -1;
    static int collectedMoney = 0;
    static boolean hasFoundPillar = false;
    static boolean hasCollectedMoney = false;
    static boolean hasWanderedOff = false;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        pastry = new char[n][];
        for (int i = 0; i < n; i++) {
            char[] input = scanner.nextLine().toCharArray();
            for (int j = 0; j < input.length; j++) {
                if (input[j] == 'S') {
                    r = i;
                    c = j;
                    input[j] = '-';
                }

                if (input[j] == 'P') {
                    if (hasFoundPillar) {
                        rP2 = i;
                        cP2 = j;
                    } else {
                        rP1 = i;
                        cP1 = j;
                        hasFoundPillar = true;
                    }
                }
            }
            pastry[i] = input;
        }
        while (!hasCollectedMoney && !hasWanderedOff) {
            move(scanner.nextLine());
            evaluateCell();
        }

        String comment = collectedMoney < 50
                ? "Bad news! You are out of the pastry shop."
                : "Good news! You succeeded in collecting enough money!";
        System.out.println(comment);
        System.out.printf("Money: %d%n", collectedMoney);
        printPastry();

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

    private static void evaluateCell() {
        if (r < 0
                || r == pastry.length
                || c < 0
                || c == pastry.length) {
            hasWanderedOff = true;
        } else if (Character.isDigit(pastry[r][c])) {
            collectedMoney += Character.getNumericValue(pastry[r][c]);
            pastry[r][c]='-';
            if (collectedMoney >= 50) {
                hasCollectedMoney = true;
            }
        } else if (pastry[r][c] == 'P') {
            if (r == rP1 && c == cP1) {
                r = rP2;
                c = cP2;
            } else {
                r = rP1;
                c = cP1;
            }
            pastry[rP1][cP1] = '-';
            pastry[rP2][cP2] = '-';
        }
    }

    private static void printPastry(){
        for (char[] chars : pastry) {
            if(hasCollectedMoney){
                pastry[r][c]='S';
            }
            System.out.println(Arrays.toString(chars).replaceAll("[\\[\\] ,]",""));
        }
    }

}

