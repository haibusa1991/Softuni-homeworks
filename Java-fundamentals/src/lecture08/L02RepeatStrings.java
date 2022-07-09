package lecture08;

import java.util.Scanner;

public class L02RepeatStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] strings = scanner.nextLine().split(" ");
        for(String string : strings){
            for (int i = 0; i < string.length(); i++) {
                System.out.print(string);
            }
        }
    }
}
