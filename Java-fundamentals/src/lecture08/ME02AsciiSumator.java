package lecture08;

import java.util.Scanner;

public class ME02AsciiSumator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char char1 = scanner.nextLine().charAt(0);
        char char2 = scanner.nextLine().charAt(0);

        if(char2<char1){
            char temp;
            temp=char2;
            char2=char1;
            char1=temp;
        }

        String input = scanner.nextLine();
        int sum=0;
        for(char currentChar:input.toCharArray()){
            if(currentChar>char1 && currentChar<char2){
                sum+=currentChar;
            }
        }
        System.out.println(sum);
    }
}
