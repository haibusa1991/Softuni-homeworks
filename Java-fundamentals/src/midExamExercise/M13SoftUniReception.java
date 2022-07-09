package midExamExercise;
//https://judge.softuni.bg/Contests/Practice/Index/2474#0

import java.util.Arrays;
import java.util.Scanner;

public class M13SoftUniReception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] employeesPerformance = new int[3];
        for (int i = 0; i < employeesPerformance.length; i++) {
            employeesPerformance[i] = Integer.parseInt(scanner.nextLine());
        }
        int peopleInQueue= Integer.parseInt(scanner.nextLine());
        int answerRate= Arrays.stream(employeesPerformance).sum();

        int workHours =(int) Math.ceil(1.0*peopleInQueue/answerRate);
        int numBreaks = (workHours-1)/3;
        System.out.printf("Time needed: %dh.",workHours+numBreaks);
    }
}
