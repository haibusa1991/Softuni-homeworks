package L03SetsAndMapsAdvanced;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class E02SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] inputs = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = inputs[0], m = inputs[1];
        Set<String> nSet = new LinkedHashSet<>();
        Set<String> mSet = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            nSet.add(scanner.nextLine());
        }
        for (int i = 0; i < m; i++) {
            mSet.add(scanner.nextLine());
        }

        nSet.retainAll(mSet);
        System.out.println(String.join(" ", nSet));
    }
}
