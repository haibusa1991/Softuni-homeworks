package lecture04;

import java.util.Scanner;

public class L04EvenPowersOfTwo {
    public static void main(String[] args) {
        Scanner scanner = new  Scanner(System.in);

        int input=Integer.parseInt(scanner.nextLine());

        for (int i = 0; i <= input; i++) {
            if (i%2==0){
                System.out.printf("%.0f\n",Math.pow(2*1.0,i*1.0));
            }
        }
    }

}
