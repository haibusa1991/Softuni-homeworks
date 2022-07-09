package L03SetsAndMapsAdvanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class E06MinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String resource = scanner.nextLine();
        Map<String, Integer> resources = new LinkedHashMap<>();
        while (!resource.equals("stop")) {
            Integer amount = Integer.parseInt(scanner.nextLine());
            resources.putIfAbsent(resource, 0);
            resources.put(resource, resources.get(resource) + amount);
            resource = scanner.nextLine();
        }
        resources.forEach((res, am) -> System.out.println(res + " -> " + am));
    }
}
