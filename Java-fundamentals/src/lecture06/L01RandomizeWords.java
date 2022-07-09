package lecture06;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class L01RandomizeWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> input = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        Random random = new Random();
        while (!input.isEmpty()){
            int index = random.nextInt(input.size());
            System.out.println(input.get(index));
            input.remove(index);
        }
    }
}
