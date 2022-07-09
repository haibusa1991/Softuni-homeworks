package finalExamExcercise;

import java.util.Scanner;

//https://judge.softuni.bg/Contests/Practice/Index/2518#0
public class FEE10WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder tour = new StringBuilder(scanner.nextLine());
        String input = scanner.nextLine();
        while (!input.equals("Travel")) {
            String command = input.split(":")[0];
            switch (command) {
                case "Add Stop":
                    int index = Integer.parseInt(input.split(":")[1]);
                    String insertion = input.split(":")[2];
                    if (index <= tour.length()
                            && index >= 0) {
                        tour.insert(index, insertion);
                    }
                    System.out.println(tour);
                    break;
                case "Remove Stop":
                    int startIndex = Integer.parseInt(input.split(":")[1]);
                    int endIndex = Integer.parseInt(input.split(":")[2]) + 1;
                    if (startIndex <= endIndex
                            && startIndex >= 0
                            && endIndex <= tour.length()) {
                        tour.replace(startIndex, endIndex, "");

                    }
                    System.out.println(tour);
                    break;
                case "Switch":
                    String oldString = input.split(":")[1];
                    String newString = input.split(":")[2];
                    if (tour.indexOf(oldString) != -1) {
                        tour = new StringBuilder(tour.toString().replaceAll(oldString, newString));
                    }
                    System.out.println(tour);
                    break;
            }
            input = scanner.nextLine();
        }
        tour.insert(0, "Ready for world tour! Planned stops: ");
        System.out.println(tour);
    }
}
