package lecture05;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class L07RemoveNegativesAndReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> values = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());


        for (int i = 0; i < values.size(); i++) {
            if (values.get(i) < 0) {
                values.remove(i);
                i = -1;
            }
        }
        if (values.size() == 0) {
            System.out.println("empty");
        } else {
            Collections.reverse(values);
            System.out.println(values.toString().replaceAll("[\\[\\],]", ""));
        }
    }

}
