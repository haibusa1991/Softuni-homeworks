package lecture02;

import java.util.Scanner;

public class E07WorldSwimmingRecord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double recordTime = Double.parseDouble(sc.nextLine());
        double distance = Double.parseDouble(sc.nextLine());
        double speed = Double.parseDouble(sc.nextLine());

        double time = (distance * speed) + (Math.floor(distance / 15) * 12.5);


        if (time < recordTime) {
            System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.", time);
        } else {
            System.out.printf("No, he failed! He was %.2f seconds slower.", time-recordTime);
        }


    }
}
