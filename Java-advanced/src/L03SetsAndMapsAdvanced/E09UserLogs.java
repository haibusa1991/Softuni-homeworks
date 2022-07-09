package L03SetsAndMapsAdvanced;

import java.util.*;

public class E09UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Integer>> users = new TreeMap<>();
        String post = scanner.nextLine();
        while (!post.equals("end")) {
            String ip = post.split(" ")[0].split("=")[1];
            String username = post.split(" ")[2].split("=")[1];
            users.putIfAbsent(username, new LinkedHashMap<>());
            Map<String, Integer> ips = users.get(username);
            ips.putIfAbsent(ip, 0);
            ips.put(ip, ips.get(ip) + 1);
            users.put(username, ips);
            post = scanner.nextLine();
        }
        for (Map.Entry<String, Map<String, Integer>> user : users.entrySet()) {
            System.out.println(user.getKey() + ":");
            Map<String, Integer> ips = user.getValue();
            System.out.print(String.join(", \n",
                    ips.toString()
                            .replaceAll("[{}]", "")
                            .replaceAll("=", " => ")));
            System.out.print(".\n");
        }
    }
}
