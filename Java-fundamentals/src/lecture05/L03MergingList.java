package lecture05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class L03MergingList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> list1 = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> list2 = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int lastIndex = Math.min(list1.size(), list2.size());

        List<Integer> outputList = new ArrayList<>();
        for (int i = 0; i < lastIndex; i++) {
            outputList.add(list1.get(i));
            outputList.add(list2.get(i));
        }

        if (list1.size() > list2.size()) {
            for (int i = lastIndex; i < list1.size(); i++) {
                outputList.add(list1.get(i));
            }
        } else {
            for (int i = lastIndex; i < list2.size(); i++) {
                outputList.add(list2.get(i));
            }
        }

        System.out.println(outputList.toString().replaceAll("[\\[\\],]", ""));

    }
}
