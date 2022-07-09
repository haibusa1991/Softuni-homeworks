package lecture01;

import java.util.Scanner;

public class L04BackIn30Minutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hours = Integer.parseInt(scanner.nextLine());
        int minutes = Integer.parseInt(scanner.nextLine());

        int timeInMin = hours * 60 + minutes + 30;
        System.out.printf("%d:%02d", (timeInMin / 60) % 24, timeInMin % 60);
    }
}
