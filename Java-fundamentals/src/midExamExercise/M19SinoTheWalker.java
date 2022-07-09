package midExamExercise;
//https://judge.softuni.bg/Contests/Practice/Index/376#0

import java.math.BigInteger;
import java.util.Scanner;

public class M19SinoTheWalker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] leaveTime = scanner.nextLine().split(":");
        int numSteps = Integer.parseInt(scanner.nextLine());
        int stepDuration = Integer.parseInt(scanner.nextLine());

        BigInteger walkTimeBI = new BigInteger(String.valueOf(numSteps)).multiply(new BigInteger(String.valueOf(stepDuration)));
        int walkTime = Integer.parseInt(walkTimeBI.mod(new BigInteger("86400")).toString());
        int leaveTimeSeconds = Integer.parseInt(leaveTime[0]) * 3600
                + Integer.parseInt(leaveTime[1]) * 60
                + Integer.parseInt(leaveTime[2]);
        long arrivalTimeSeconds = leaveTimeSeconds + walkTime;
        int hours = (int) (arrivalTimeSeconds / 3600) % 24;
        int minutes = (int) (arrivalTimeSeconds % 3600) / 60;
        int seconds = (int) arrivalTimeSeconds % 60;
        System.out.printf("Time Arrival: %02d:%02d:%02d", hours, minutes, seconds);

    }
}

