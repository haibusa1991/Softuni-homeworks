package lecture02;

import java.util.Scanner;

public class ME02SleepyTomCat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int PLAYTIME_NORM = 30000;
        int holidays = Integer.parseInt(sc.nextLine());
        int playtime = holidays*127+(365-holidays)*63;
        int playtimeH = Math.abs((playtime -PLAYTIME_NORM)/60);
        int playtimeM = Math.abs((playtime-PLAYTIME_NORM)%60);

        if (playtime>PLAYTIME_NORM) {
            System.out.printf("Tom will run away\n%d hours and %d minutes more for play", playtimeH, playtimeM);
        }else {
            System.out.printf("Tom sleeps well\n%d hours and %d minutes less for play", playtimeH, playtimeM);
        }
    }
}
