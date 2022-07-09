package lecture03;

import java.util.Arrays;
import java.util.Scanner;

public class L04ReverseAnArrayOfStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputArray = scanner.nextLine().split(" ");
        for (int i = 0; i < inputArray.length / 2; i++) {
            String tempVar = inputArray[i];
            int k = inputArray.length - 1 - i;
            inputArray[i] = inputArray[k];
            inputArray[k] = tempVar;
        }
        Arrays.stream(inputArray).forEach(e -> System.out.print(e + " "));
    }
}
