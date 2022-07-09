package lecture06;

import java.util.Scanner;

public class ME06WeddingSeats {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char finalSector = scanner.nextLine().charAt(0);
        int sectorMaxRows = Integer.parseInt(scanner.nextLine());
        int numSeats = Integer.parseInt(scanner.nextLine());

        int additionalSeats;
        int totalSeats=0;
        for (int sector = 'A'; sector <= finalSector; sector++) {
            for (int row = 1; row <= sectorMaxRows; row++) {
                if (row % 2 == 0) {
                    additionalSeats = 2;
                }else {
                    additionalSeats=0;
                }
                for (int seat = 'a'; seat <'a'+numSeats+additionalSeats ; seat++) {
                    System.out.println(""+(char) sector + row +(char) seat);
                    totalSeats++;
                }
            }
            sectorMaxRows++;

        }
        System.out.print(totalSeats);
    }
}
