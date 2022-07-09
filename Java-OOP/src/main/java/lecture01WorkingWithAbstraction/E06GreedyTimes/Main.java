
package lecture01WorkingWithAbstraction.E06GreedyTimes;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long bagCapacity = Long.parseLong(scanner.nextLine());
        String[] safe = scanner.nextLine().split("\\s+");

        Bag bag = new Bag(bagCapacity);
        List<Treasure> treasures = new ArrayList<>();

        for (int i = 0; i < safe.length; i += 2) {
            String treasureName = safe[i];
            int treasureAmount = Integer.parseInt(safe[i + 1]);
            Treasure treasure = null;

            if (treasureName.length() == 3) {
                treasure = new Treasure(Type.CASH, treasureAmount, treasureName);
            } else if (treasureName.toLowerCase().endsWith("gem")) {
                treasure = new Treasure(Type.GEM, treasureAmount, treasureName);
            } else if (treasureName.equalsIgnoreCase("gold")) {
                treasure = new Treasure(Type.GOLD, treasureAmount, treasureName);
            }

            if (treasure != null) {
                treasures.add(treasure);
            }

        }

        for (Treasure treasure : treasures) {
            if (bag.canTake(treasure)) {
                bag.addTreasure(treasure);
            }
        }

        System.out.println(bag.getBagContents());
    }
}
