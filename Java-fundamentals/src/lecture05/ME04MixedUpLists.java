package lecture05;

import java.util.*;
import java.util.stream.Collectors;

public class ME04MixedUpLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> input1 = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> input2 = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> mixedList = new ArrayList<>();

        while (!input1.isEmpty() && !input2.isEmpty()) {
            mixedList.add(input1.get(0));
            input1.remove(0);

            if (!input2.isEmpty()) {
                mixedList.add(input2.get(input2.size() - 1));
                input2.remove(input2.size() - 1);
            }
        }

        int upperValue = 0;
        int lowerValue = 0;

        if (!input1.isEmpty()) {
            upperValue = Math.max(input1.get(0), input1.get(1));
            lowerValue = Math.min(input1.get(0), input1.get(1));
        } else {
            upperValue = Math.max(input2.get(0), input2.get(1));
            lowerValue = Math.min(input2.get(0), input2.get(1));
        }

        for (int i = 0; i < mixedList.size(); i++) {
            if (mixedList.get(i) <= lowerValue || mixedList.get(i) >= upperValue) {
                mixedList.remove(i);
                i = -1;
            }
        }
        Collections.sort(mixedList);
        System.out.println(mixedList.toString().replaceAll("[\\[\\],]", ""));
    }
}