package lecture02;

import java.util.Scanner;

public class E01SumSeconds {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int competitor1 = Integer.parseInt(sc.nextLine());
        int competitor2 = Integer.parseInt(sc.nextLine());
        int competitor3 = Integer.parseInt(sc.nextLine());

        int totalTime = competitor1 + competitor2 + competitor3;
        int totalMinutes = totalTime / 60;
        int totalSeconds = totalTime % 60;

        String leadingZero = "";

        if (totalSeconds < 10) {
            leadingZero = "0";
        }
        System.out.println(totalMinutes + ":" + leadingZero + totalSeconds);
    }
}

