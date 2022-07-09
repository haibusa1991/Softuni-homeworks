package ExamPreparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Bouquets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> tulipStack = new ArrayDeque<>();
        ArrayDeque<Integer> daffodilQueue;

        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(tulipStack::push);
        daffodilQueue = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int numBouquets = 0;
        int remainingFlowers = 0;
        while (!tulipStack.isEmpty() && !daffodilQueue.isEmpty()) {
            int tulips = tulipStack.pop();
            int daffodils = daffodilQueue.poll();
            while (tulips + daffodils > 15) {
                tulips -= 2;
            }
            if (tulips + daffodils == 15) {
                numBouquets++;
            } else {
                remainingFlowers += tulips + daffodils;
            }
        }

        numBouquets += remainingFlowers / 15;
        if (numBouquets >= 5) {
            System.out.printf("You made it! You go to the competition with %d bouquets!", numBouquets);
        } else {
            System.out.printf("You failed... You need more %d bouquets.", 5 - numBouquets);
        }
    }
}
