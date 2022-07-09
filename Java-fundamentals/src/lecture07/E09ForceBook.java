package lecture07;

import java.util.*;

public class E09ForceBook {
    static Map<String, List<String>> users = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!input.equals("Lumpawaroo")) {
            if (input.contains("|")) {
                addUser(input);
            } else {
                switchUser(input);
            }
            input = scanner.nextLine();
        }
        printUsers();
    }

    private static void addUser(String inputString) {

        String user = inputString.split(" \\| ")[1];
        String side = inputString.split(" \\| ")[0];
        boolean doesUserExist = false;
        for (Map.Entry<String, List<String>> currentSide : users.entrySet()) {
            List<String> currentSideUsers = currentSide.getValue();
            if (currentSideUsers.contains(user)) {
                doesUserExist = true;
                break;
            }
        }
        if (!doesUserExist) {
            users.putIfAbsent(side, new ArrayList<>() {{
                add(user);
            }});

            if (users.containsKey(side)) {
                List<String> currentUsers = users.get(side);
                if (!currentUsers.contains(user)) {
                    currentUsers.add(user);
                }
                users.put(side, currentUsers);
            }
        }
    }

    private static void addUser(String user, String side) {
        users.putIfAbsent(side, new ArrayList<>() {{
            add(user);
        }});
        if (users.containsKey(side)) {
            List<String> currentUsers = users.get(side);
            if (!currentUsers.contains(user)) {
                currentUsers.add(user);
            }
            users.put(side, currentUsers);
            System.out.println(user + " joins the " + side + " side!");
        }
    }

    private static void switchUser(String inputString) {
        String user = inputString.split(" -> ")[0];
        String targetSide = inputString.split(" -> ")[1];
        boolean hasSwitchedUser = false;
        for (Map.Entry<String, List<String>> currentSide : users.entrySet()) { //проверявам дали такъв ползвател въобще съществува
            List<String> currentSideUsers = currentSide.getValue();
            if (currentSideUsers.contains(user)) {
                hasSwitchedUser = true;
                currentSideUsers.remove(user);
                String sideToUpdate = currentSide.getKey();
                users.put(sideToUpdate, currentSideUsers);
                addUser(user, targetSide);
            }
        }
        if (!hasSwitchedUser) {
            addUser(user, targetSide);
        }
    }

    private static void printUsers() {
        users.entrySet()
                .stream()
                .sorted(Map.Entry.<String, List<String>>comparingByValue((e1, e2) -> Integer.compare(e2.size(), e1.size())).thenComparing(Map.Entry.comparingByKey()))
                .filter(w -> w.getValue().size() > 0)
                .forEach(e -> {
                    List<String> currentSideUsers = e.getValue();
                    System.out.println("Side: " + e.getKey() + ", Members: " + currentSideUsers.size());
                    currentSideUsers.stream()
                            .sorted(String::compareTo)
                            .forEach(w -> System.out.println("! " + w));
                });

    }
}


