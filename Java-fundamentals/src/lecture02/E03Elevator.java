package lecture02;

import java.util.Scanner;

public class E03Elevator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numPeople = Integer.parseInt(scanner.nextLine());
        int elevatorCapacity = Integer.parseInt(scanner.nextLine());

        int numCourses = numPeople / elevatorCapacity;
        if (numPeople % elevatorCapacity != 0) numCourses++;
        System.out.println(numCourses);
    }
}
