package L01StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class E07SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> history = new ArrayDeque<>();
        StringBuilder currentText = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            switch (input.charAt(0)){
                case '1':
                    history.push(currentText.toString());
                    currentText.append(input.substring(2));
                    break;
                case '2':
                    history.push(currentText.toString());
                    int numCharsToDelete=Integer.parseInt(input.substring(2));
                    currentText.delete(currentText.length()-numCharsToDelete,currentText.length());
                    break;
                case '3':
                    int charToReturn = Integer.parseInt(input.substring(2));
                    System.out.println(currentText.charAt(charToReturn-1));
                    break;
                case '4':
                    currentText=new StringBuilder(history.pop());
            }
        }
    }
}
