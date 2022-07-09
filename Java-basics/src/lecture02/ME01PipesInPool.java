package lecture02;

import java.util.Scanner;

public class ME01PipesInPool {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int poolVolume = Integer.parseInt(sc.nextLine());
        int pipe1Flow = Integer.parseInt(sc.nextLine());
        int pipe2Flow = Integer.parseInt(sc.nextLine());
        double hoursMissing = Double.parseDouble(sc.nextLine());

        double pipe1Liters = pipe1Flow * hoursMissing;
        double pipe2Liters = pipe2Flow * hoursMissing;
        double totalLiters = pipe1Liters + pipe2Liters;

        if (totalLiters < poolVolume) {
            double fillPercentage = 100.0 * totalLiters / poolVolume;
            double pipe1FillPercentage = 100.0 * pipe1Liters / totalLiters;
            double pipe2FillPercentage = 100.0 * pipe2Liters / totalLiters;

            System.out.printf("The pool is %.2f%% full. Pipe 1: %.2f%% Pipe 2: %.2f%%", fillPercentage, pipe1FillPercentage, pipe2FillPercentage);
        } else {
            System.out.printf("For %.2f hours the pool overflows with %.2f liters.", hoursMissing, totalLiters - poolVolume);


        }
    }
}
