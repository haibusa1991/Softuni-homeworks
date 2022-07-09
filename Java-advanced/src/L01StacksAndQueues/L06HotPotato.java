package L01StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class L06HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> children = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toCollection(ArrayDeque::new));
        int numHops = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> survivors = new ArrayDeque<>();
        while (children.size() + survivors.size() != 1) {
            for (int i = 0; i < numHops - 1; i++) {
                if (children.isEmpty()) {
                    children = survivors.clone();
                    survivors.clear();
                }
                survivors.offer(children.poll());
                if (children.isEmpty()) {
                    children = survivors.clone();
                    survivors.clear();
                }
            }
            System.out.println("Removed " + children.poll());
        }
        if (children.isEmpty()) {
            System.out.println("Last is " + survivors.poll());
        } else {
            System.out.println("Last is " + children.poll());
        }
    }
}
