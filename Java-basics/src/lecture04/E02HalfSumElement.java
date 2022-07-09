package lecture04;

import java.util.Scanner;

public class E02HalfSumElement {
    public static void main(String[] args) {
        Scanner scanner = new  Scanner(System.in);

        int numNumbers = Integer.parseInt(scanner.nextLine());

        int sum=0;
        int maxNumber=Integer.MIN_VALUE;

        for (int i = 0; i < numNumbers; i++) {
            int value = Integer.parseInt(scanner.nextLine());
            sum+=value;

            if (value>maxNumber){
                maxNumber=value;
            }
        }

        sum-=maxNumber;
        if (sum==maxNumber){
            System.out.printf("Yes\nSum = %d",sum);
        }else {
            System.out.printf("No\nDiff = %d",Math.abs(maxNumber-sum));
        }
    }
}
