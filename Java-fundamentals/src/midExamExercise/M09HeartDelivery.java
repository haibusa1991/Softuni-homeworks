package midExamExercise;
//https://judge.softuni.bg/Contests/Practice/Index/2031#2
import java.util.Arrays;
import java.util.Scanner;

public class M09HeartDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] neighbourhood = Arrays.stream(scanner.nextLine().split("@"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int cupidLocation = 0;
        String input = scanner.nextLine();
        while (!input.equals("Love!")) {
            int jumpSpan = Integer.parseInt(input.split(" ")[1]);
            if (cupidLocation + jumpSpan >= neighbourhood.length) {
                cupidLocation = 0;
            } else {
                cupidLocation += jumpSpan;
            }

            if (neighbourhood[cupidLocation] > 2) {
                neighbourhood[cupidLocation] -= 2;
            } else if (neighbourhood[cupidLocation] == 2) {
                System.out.printf("Place %d has Valentine's day.\n", cupidLocation);
                neighbourhood[cupidLocation] = 0;
            } else {
                System.out.printf("Place %d already had Valentine's day.\n", cupidLocation);
            }
            input = scanner.nextLine();
        }
        System.out.printf("Cupid's last position was %d.\n", cupidLocation);

        int failedPlaces = 0;
        for (int house : neighbourhood) {
            if (house > 0) {
                failedPlaces++;
            }
        }
        if (failedPlaces > 0) {
            System.out.printf("Cupid has failed %d places.\n", failedPlaces);
        } else {
            System.out.println("Mission was successful.");
        }
    }
}
