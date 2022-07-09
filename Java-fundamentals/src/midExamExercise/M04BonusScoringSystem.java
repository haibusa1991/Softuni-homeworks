package midExamExercise;

import java.util.Scanner;

//https://judge.softuni.bg/Contests/Practice/Index/2028#0
public class M04BonusScoringSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numStudents = Integer.parseInt(scanner.nextLine());
        int numLectures = Integer.parseInt(scanner.nextLine());
        int additionalBonus = Integer.parseInt(scanner.nextLine());

        int maxBonus=0;
        int maxAttendance=0;
        for (int i = 0; i < numStudents; i++) {
            int currentAttendance = Integer.parseInt(scanner.nextLine());
            int currentBonus = (int) Math.ceil((1.0 * currentAttendance / numLectures) * (5 + additionalBonus));

            if(currentAttendance>maxAttendance){
                maxAttendance=currentAttendance;
                maxBonus=currentBonus;
            }
        }

        System.out.printf("Max Bonus: %d.\n" +
                "The student has attended %d lectures.",
                maxBonus,
                maxAttendance);

    }
}
