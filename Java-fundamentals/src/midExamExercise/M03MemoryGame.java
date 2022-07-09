package midExamExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

//https://judge.softuni.bg/Contests/Practice/Index/2517#2
public class M03MemoryGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> elements = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        int numMoves = 0;
        String input = scanner.nextLine();
        boolean hasWon = false;
        while (!input.equals("end")) {
            if (hasWon) {
                input = scanner.nextLine();
                continue;
            }
            numMoves++;
            int[] indices = Arrays.stream(input.split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            if (indices[0] < 0
                    || indices[0] > elements.size() - 1
                    || indices[1] < 0
                    || indices[1] > elements.size() - 1
                    || indices[0] == indices[1]) {
                System.out.println("Invalid input! Adding additional elements to the board");
                String element = "-" + numMoves + "a";
                for (int i = 0; i < 2; i++) {
                    elements.add(elements.size() / 2, element);
                }
            } else if (elements.get(indices[0]).equals(elements.get(indices[1]))) {
                System.out.printf("Congrats! You have found matching elements - %s!\n", elements.get(indices[0]));
                elements.set(indices[0], "DELETEME");
                elements.set(indices[1], "DELETEME");
                elements.removeIf(element -> element.equals("DELETEME"));
                if (elements.isEmpty()) {
                    hasWon = true;
                }
            } else {
                System.out.println("Try again!");
            }
            input = scanner.nextLine();
        }
        if (elements.isEmpty()) {
            System.out.printf("You have won in %d turns!", numMoves);
        } else {
            System.out.println("Sorry you lose :(");
            elements.forEach(e -> System.out.print(e + " "));
        }
    }
}