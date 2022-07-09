package L01StacksAndQueues;

import java.util.*;
import java.util.stream.Collectors;

public class L07MathPotato {
    private static List<Integer> primes = new ArrayList<>() {{
        add(2);
    }};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> children = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toCollection(ArrayDeque::new));
        int numHops = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> survivors = new ArrayDeque<>();
        int numCycle = 0;
        while (children.size() + survivors.size() != 1) {
            numCycle++;
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
            if (isPrime(numCycle)) {
                String child = children.poll();
                System.out.println("Prime " + child);
                children.offerFirst(child);
            } else {
                System.out.println("Removed " + children.poll());
            }
        }
        if (children.isEmpty()) {
            System.out.println("Last is " + survivors.poll());
        } else {
            System.out.println("Last is " + children.poll());
        }
    }

    private static boolean isPrime(int n) {
        calculatePrimesToN(n);
        return primes.contains(n);
    }

    private static void calculatePrimesToN(int endNumber) {
        for (int i = primes.get(primes.size() - 1); i <= endNumber; i++) {
            boolean isPrime = true;
            for (Integer prime : primes) {
                if (i % prime == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes.add(i);
            }

        }
    }
}



