package L01StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class L02SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] expression = scanner.nextLine().replace(" + "," ").replace(" - "," -").split(" ");
        ArrayDeque<Integer> values = new ArrayDeque<>();
        for(String currentValue : expression){
            values.push(Integer.parseInt(currentValue));
        }
        while (values.size()>1){
            values.push(values.pop()+values.pop());
        }
        System.out.println(values.pop());

    }
}
