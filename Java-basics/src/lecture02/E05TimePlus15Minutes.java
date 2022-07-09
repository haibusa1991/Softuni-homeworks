package lecture02;

import java.util.Scanner;

public class E05TimePlus15Minutes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int hours = Integer.parseInt(sc.nextLine());
        int minutes = Integer.parseInt(sc.nextLine());
        String leadingZero = "";

        minutes += 15;
        if (minutes >= 60) {
            hours += 1;
            minutes -=60;
        }

        if (hours >= 24) {
            hours -= 24;
        }

        if (minutes < 10) {
            leadingZero = "0";
        }

        System.out.println(hours + ":" + leadingZero + minutes);
    }
}

