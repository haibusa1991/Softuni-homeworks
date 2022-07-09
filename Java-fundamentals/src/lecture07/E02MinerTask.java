package lecture07;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class E02MinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> resources = new LinkedHashMap<>();

        String input1 = scanner.nextLine();
        while (!input1.equalsIgnoreCase("stop")) {
            int input2 = Integer.parseInt(scanner.nextLine());
            if (!resources.containsKey(input1)) {
                resources.put(input1, input2);
            } else {
                resources.put(input1, resources.get(input1) + input2);
            }
            input1 = scanner.nextLine();
        }
        resources.forEach((s, integer) -> System.out.println(s + " -> " + integer));
    }
}
