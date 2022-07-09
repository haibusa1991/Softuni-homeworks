package lecture05;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class L01SumAdjacentEqualNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> input = Arrays.stream(scanner.nextLine().split(" "))
                .map(Double::parseDouble)
                .collect(Collectors.toList());

        for (int i = 0; i < input.size() - 1; i++) {
            if (input.get(i).equals(input.get(i + 1))) {
                input.set(i, input.get(i) + input.get(i + 1));
                input.remove(i + 1);
                i = -1;
            }
        }
        String output = "";
        DecimalFormat df = new DecimalFormat("0.#");
        for (int i = 0; i < input.size(); i++) {
            output += df.format(input.get(i)) + " ";
        }
        System.out.println(output);

    }
}
