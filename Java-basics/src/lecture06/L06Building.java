package lecture06;

import java.util.Scanner;

public class L06Building {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int floors = Integer.parseInt(scanner.nextLine());
        int rooms = Integer.parseInt(scanner.nextLine());

        for (int i = floors; i > 0; i--) {
            String letter = "";

            if (i == floors) {
                letter = "L";
            } else if (i % 2 == 0) {
                letter = "O";
            } else {
                letter = "A";
            }

            for (int j = 0; j < rooms; j++) {
                System.out.printf("%s%d%s ",letter,i,j);
            }
            System.out.print("\n");
        }
    }
}
