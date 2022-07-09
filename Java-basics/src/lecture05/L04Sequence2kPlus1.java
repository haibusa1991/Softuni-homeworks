package lecture05;

import java.util.Scanner;

public class L04Sequence2kPlus1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());


        int previousNumber=1;

        while (previousNumber<=n){
            System.out.println(previousNumber);
            previousNumber=previousNumber*2+1;
        }
    }
}
