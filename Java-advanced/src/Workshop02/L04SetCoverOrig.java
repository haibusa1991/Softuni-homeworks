package Workshop02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class L04SetCoverOrig {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> universe = Arrays.stream(scanner.nextLine().substring(10).split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int n = Integer.parseInt(scanner.nextLine().substring(16));
        List<Integer[]> sets = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            sets.add(Arrays.stream(scanner.nextLine().split(", "))
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new));
        }
        List<Integer[]> selectedSets = new ArrayList<>();
        while (!universe.isEmpty()) {
            int bestSet = 0;
            int bestMatches = 0;
            for (int i = 0; i < sets.size(); i++) {
                Integer[] currentSet = sets.get(i);
                int numMatches = 0;
                for (Integer integer : currentSet) {
                    if (universe.contains(integer)) {
                        numMatches++;
                    }
                }
                if (bestMatches < numMatches) {
                    bestSet = i;
                    bestMatches = numMatches;
                }
            }
            selectedSets.add(sets.get(bestSet));
            universe.removeAll(Arrays.stream(sets.get(bestSet)).collect(Collectors.toList()));
            sets.remove(bestSet);
        }
        System.out.printf("Sets to take (%d):%n", selectedSets.size());
        for (Integer[] selectedSet : selectedSets) {
            System.out.println(Arrays
                    .toString(selectedSet)
                    .replace("[", "{ ")
                    .replace("]", " }"));
        }
    }
}



