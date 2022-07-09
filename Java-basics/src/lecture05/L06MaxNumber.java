package lecture05;

import java.util.Scanner;

public class L06MaxNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int maxNumber = Integer.MIN_VALUE;

        String input="";
        while (true) {
            input=scanner.nextLine();

            if(input.equalsIgnoreCase("stop")){
                break;
            }

            if(Integer.parseInt(input)>maxNumber){
                maxNumber=Integer.parseInt(input);
            }
        }
        System.out.println(maxNumber);
    }
}
