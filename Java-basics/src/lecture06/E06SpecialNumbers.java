package lecture06;

import java.util.Scanner;

public class E06SpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1111; i < 10000; i++) {
            boolean isSpecial = true;
            for (int j = 0; j < 4; j++) {
                String value = "" + i;
                int digit = Integer.parseInt("" + value.charAt(j));

                if ((digit==0) || (n % digit != 0)) {
                    isSpecial = false;
                    break;
                }
            }
            if (isSpecial) {
                System.out.print(i + " ");
            }
        }
    }
}
