package lecture03;

import java.util.Scanner;

public class L10InvalidNumber {
    public static void main(String[] args) {
        Scanner scanner = new  Scanner(System.in);
        int input = Integer.parseInt(scanner.nextLine());

        if ((input>=100 && input <=200) || input==0){

        } else {
            System.out.println("invalid");
        }
    }
}
