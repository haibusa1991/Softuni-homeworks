package lecture05;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E01Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> train = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int capacity = Integer.parseInt(scanner.nextLine());

        String command = scanner.nextLine();
        while (!command.equalsIgnoreCase("end")) {
            String[] com = command.split(" ");
            if (com[0].equalsIgnoreCase("add")) {
                train.add(Integer.parseInt(com[1]));
            } else {
                for (int i = 0; i < train.size(); i++) {
                    if (train.get(i) + Integer.parseInt(com[0]) <= capacity) {
                        train.set(i, train.get(i) + Integer.parseInt(com[0]));
                        break;
                    }
                }
            }
            command = scanner.nextLine();
        }
        System.out.println(train.toString().replaceAll("[\\[\\],]", ""));
    }
}
