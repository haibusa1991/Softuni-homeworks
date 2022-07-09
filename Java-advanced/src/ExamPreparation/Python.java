package ExamPreparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Python {
    static char[][] field;
    static int r;
    static int c;
    static int pythonLength = 1;
    static int fieldSize;
    static int foodInitial = 0;
    static boolean hasDied = false;
    static boolean hasWon = false;
    static ArrayDeque<String> commands;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        fieldSize = Integer.parseInt(scanner.nextLine());
        field = new char[fieldSize][];
        commands = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .collect(Collectors.toCollection(ArrayDeque::new));

        for (int i = 0; i < fieldSize; i++) {
            char[] currentLine = scanner.nextLine().replaceAll(" ", "").toCharArray();
            field[i] = currentLine;
            for (int j = 0; j < fieldSize; j++) {
                if (currentLine[j] == 's') {
                    r = i;
                    c = j;
                }
                if (currentLine[j] == 'f') {
                    foodInitial++;
                }
            }
        }

        while (!commands.isEmpty()) {
            move(commands.poll());
            examineCell();
            if (hasWon || hasDied) {
                break;
            }
        }

        if (hasWon) {
            System.out.printf("You win! Final python length is %d", pythonLength);
        } else if (hasDied) {
            System.out.println("You lose! Killed by an enemy!");
        } else if (pythonLength-1 < foodInitial) {
            System.out.printf("You lose! There is still %d food to be eaten.", foodInitial - (pythonLength-1));
        }
    }

    private static void move(String direction) {
        switch (direction) {
            case "up":
                r--;
                if (r < 0) {
                    r = fieldSize - 1;
                }
                break;
            case "right":
                c++;
                if (c == fieldSize) {
                    c = 0;
                }
                break;
            case "down":
                r++;
                if (r == fieldSize) {
                    r = 0;
                }
                break;
            case "left":
                c--;
                if (c < 0) {
                    c = fieldSize - 1;
                }
                break;
        }
    }

    private static void examineCell() {
        char cell = field[r][c];
        if (cell == 'e') {
            hasDied = true;
        }

        if (cell == 'f') {
            pythonLength++;
            field[r][c] = '*';
        }

        if (pythonLength-1 == foodInitial) {
            hasWon = true;
        }

    }
}
