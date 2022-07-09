package midExamExercise;

import java.util.Arrays;
import java.util.Scanner;

//https://judge.softuni.bg/Contests/Practice/Index/2517#1
public class M02TheLift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int peopleInQueue = Integer.parseInt(scanner.nextLine());
        int[] wagons = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < wagons.length; i++) {
            int freeSeats = 4 - wagons[i];
            if (freeSeats > 0 && peopleInQueue > freeSeats) {
                wagons[i] = 4;
                peopleInQueue -= freeSeats;
            } else if (freeSeats > 0 && peopleInQueue <= freeSeats) {
                wagons[i] = wagons[i] + peopleInQueue;
                peopleInQueue = 0;
                break;
            }
        }

        if (wagons.length * 4 > Arrays.stream(wagons).sum()) {
            System.out.println("The lift has empty spots!");
        } else if (peopleInQueue > 0) {
            System.out.printf("There isn't enough space! %d people in a queue!\n", peopleInQueue);
        }
        Arrays.stream(wagons).forEach(e -> System.out.print(e + " "));
    }

}
