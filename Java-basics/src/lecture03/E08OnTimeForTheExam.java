package lecture03;

import java.util.Scanner;

public class E08OnTimeForTheExam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int examHour = Integer.parseInt(scanner.nextLine());
        int examMinute = Integer.parseInt(scanner.nextLine());
        int arrivalHour = Integer.parseInt(scanner.nextLine());
        int arrivalMinute = Integer.parseInt(scanner.nextLine());

        int examTime = examHour * 60 + examMinute;
        int arrivalTime = arrivalHour * 60 + arrivalMinute;

        int timeDifference = arrivalTime - examTime;
        boolean isEarly = timeDifference < -30;

        boolean isOnTime = (arrivalTime - examTime >= -30 && arrivalTime - examTime <= 0);

        timeDifference = Math.abs(timeDifference);

        if (isEarly) {

            if (timeDifference >= 60) {
                System.out.printf("Early\n%d:%02d hours before the start", timeDifference / 60, timeDifference % 60);
            } else {
                System.out.printf("Early\n%d minutes before the start", timeDifference);
            }

        } else if (isOnTime) {
            if (timeDifference == 0) {
                System.out.println("On time");
            } else {
                System.out.printf("On time\n%d minutes before the start", timeDifference);
            }

        } else {

            if (timeDifference >= 60) {
                System.out.printf("Late\n%d:%02d hours after the start", timeDifference / 60, timeDifference % 60);
            } else {
                System.out.printf("Late\n%d minutes after the start", timeDifference);
            }
        }

    }
}
