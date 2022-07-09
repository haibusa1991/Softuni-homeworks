package L03SetsAndMapsAdvanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class E11LogsAggregator {
    public static void main(String[] args) throws IOException {

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader scanner = new BufferedReader(isr);
        int n = Integer.parseInt(scanner.readLine());
        Map<String, Set<String>> users = new TreeMap<>();
        while (n-- > 0) {
            String[] currentUser = scanner.readLine().split(" ");
            String username = currentUser[1];
            String ipAddress = currentUser[0];
            int duration = -Integer.parseInt(currentUser[2]);
            users.putIfAbsent(username, new TreeSet<>() {{
                add("0");
            }});
            Set<String> ipAddresses = users.get(username);
            String currentDuration = ipAddresses.iterator().next();
            ipAddresses.remove(currentDuration);
            ipAddresses.add((Integer.parseInt(currentDuration) + duration) + "");
            ipAddresses.add(ipAddress);
            users.put(username, ipAddresses);
        }
        users.forEach((k, v) -> {
            System.out.print(k + ": " + v.iterator().next().substring(1));
            String totalDuration = v.iterator().next();
            v.remove(totalDuration);
            System.out.print(" [" + String.join(", ", v) + "]\n");
        });
    }
}
