package Workshop02;

import java.util.*;
import java.util.stream.Collectors;

public class L03SumOfCoins {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] elements = in.nextLine().substring(7).split(", ");
        int[] coins = new int[elements.length];
        for (int i = 0; i < coins.length; i++) {
            coins[i] = Integer.parseInt(elements[i]);
        }

        int targetSum = Integer.parseInt(in.nextLine().substring(5));

        Map<Integer, Integer> usedCoins = chooseCoins(coins, targetSum);
        if (usedCoins.isEmpty()) {
            System.out.println("Error");
        } else {
            int totalCoins = usedCoins.values().stream().mapToInt(e -> e).sum();
            System.out.println("Number of coins to take: " + totalCoins);
            for (Map.Entry<Integer, Integer> usedCoin : usedCoins.entrySet()) {
                System.out.println(usedCoin.getValue() + " coin(s) with value " +usedCoin.getKey());
            }
        }
    }

    public static Map<Integer, Integer> chooseCoins(int[] coins, int targetSum) {
        Map<Integer, Integer> usedCoins = new LinkedHashMap<>();
        coins = Arrays.stream(coins)
                .sorted()
                .boxed()
                .collect(Collectors.toList())
                .stream()
                .sorted(Comparator.reverseOrder())
                .mapToInt(e -> e)
                .toArray();

        for (int coin : coins) {
            if (coin <= targetSum) {
                int numCoins = targetSum / coin;
                usedCoins.putIfAbsent(coin, 0);
                usedCoins.put(coin, usedCoins.get(coin) + numCoins);
                targetSum -= coin * numCoins;
            }
        }
        if (targetSum != 0) {
            usedCoins.clear();
        }
        return usedCoins;
    }
}
