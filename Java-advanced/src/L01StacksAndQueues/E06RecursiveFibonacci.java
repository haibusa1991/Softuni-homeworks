package L01StacksAndQueues;

import java.math.BigInteger;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class E06RecursiveFibonacci {
    private static Map<Integer, BigInteger> cache = new LinkedHashMap<>() {{
        put(0, BigInteger.ZERO);
        put(1, BigInteger.ONE);
        put(2, BigInteger.ONE);
    }};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(getFibonacciNumber(Integer.parseInt(scanner.nextLine()) + 1));
    }

    private static BigInteger getFibonacciNumber(int n) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        BigInteger num = BigInteger.ZERO;
        num = num.add(getFibonacciNumber(n - 1)).add(getFibonacciNumber(n - 2));
        cache.put(n, num);
        return num;
    }
}
