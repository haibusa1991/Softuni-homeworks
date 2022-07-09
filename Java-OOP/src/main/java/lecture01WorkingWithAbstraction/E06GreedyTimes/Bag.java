package lecture01WorkingWithAbstraction.E06GreedyTimes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Bag {
    private final long capacity;
    private long occupiedSpace = 0;
    private List<Treasure> gold = new ArrayList<>();
    private List<Treasure> gems = new ArrayList<>();
    private List<Treasure> cash = new ArrayList<>();

    public Bag(long capacity) {
        this.capacity = capacity;
    }

    public void addTreasure(Treasure treasure) {
        if (!canTake(treasure)) {
            throw new IllegalStateException("Insufficient bag capacity");
        }

        switch (treasure.getType()) {
            case GOLD:
                updateQuantity(treasure, gold);
                break;

            case GEM:
                updateQuantity(treasure, gems);
                break;

            case CASH:
                updateQuantity(treasure, cash);
                break;
        }

        occupiedSpace += treasure.getAmount();
    }

    public boolean canTake(Treasure treasure) {
        int amount = treasure.getAmount();
        if (amount + occupiedSpace > capacity) {
            return false;
        }

        switch (treasure.getType()) {
            case GEM:
                if (amount + getGemsAmount() > getGoldAmount()) {
                    return false;
                }
                break;

            case CASH:
                if (amount + getCashAmount() > getGemsAmount()) {
                    return false;
                }
                break;
        }
        return true;
    }

    private List<List<Treasure>> collectTreasures() {
        return List.of(gold, gems, cash);
    }

    public String getBagContents() {

        //sort all treasures by total amount in descending order
        List<List<Treasure>> bagContents = collectTreasures()
                .stream()
                .sorted((e1, e2) -> {
                    long sum1 = e1.stream().mapToLong(Treasure::getAmount).sum();
                    long sum2 = e2.stream().mapToLong(Treasure::getAmount).sum();
                    return Long.compare(sum2, sum1);
                })
                .collect(Collectors.toList());

        //collect all treasures to a string builder.
        StringBuilder sb = new StringBuilder();
        for (List<Treasure> currentTreasureType : bagContents) {
            if (currentTreasureType.isEmpty()) {
                continue;
            }

            sb.append(String.format("<%s> $%d%n", currentTreasureType.get(0).getType().getName(),
                    currentTreasureType.stream().mapToLong(Treasure::getAmount).sum()));

            currentTreasureType.stream()
                    .sorted(Comparator.comparing(Treasure::getName).reversed().thenComparing(Treasure::getAmount))
                    .forEach(e -> sb.append(String.format("##%s - %d%n", e.getName(), e.getAmount())));
        }

        return sb.toString();
    }

    private long getGoldAmount() {
        return gold.stream().mapToLong(Treasure::getAmount).sum();
    }

    private long getGemsAmount() {
        return gems.stream().mapToLong(Treasure::getAmount).sum();
    }

    private long getCashAmount() {
        return cash.stream().mapToLong(Treasure::getAmount).sum();
    }

    private void updateQuantity(Treasure newTreasure, List<Treasure> treasures) {
        for (Treasure currentTreasure : treasures) {
            if (currentTreasure.getName().equals(newTreasure.getName())) {
                currentTreasure.addAmount(newTreasure.getAmount());
                return;
            }
        }
        treasures.add(newTreasure);
    }

}
