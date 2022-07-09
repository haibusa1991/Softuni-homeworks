package lecture07;

import java.util.*;

public class E08CompanyUsers {
    public static void main(String[] args) {
        Map<String, List<String>> users = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String company = input.split(" -> ")[0];
            String user = input.split(" -> ")[1];
            if (!users.containsKey(company)) {
                users.put(company, new ArrayList<>() {{
                    add(user);
                }});
            } else {
                List<String> currentUsers = users.get(company);
                if (!currentUsers.contains(user)) {
                    currentUsers.add(user);
                }
                users.put(company, currentUsers);
            }
            input = scanner.nextLine();
        }
        users.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(e -> {
                    System.out.println(e.getKey());
                    e.getValue().forEach(w -> System.out.println("-- " + w));
                });
    }
}
