package lecture08;

import java.util.Scanner;

public class E06ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder input = new StringBuilder(scanner.nextLine());
        for (int i = 0; i < input.length()-1; i++) {
            if(input.charAt(i)==input.charAt(i+1)){
                input.deleteCharAt(i+1);
                i=-1;
            }
        }
        System.out.println(input);
    }
}
