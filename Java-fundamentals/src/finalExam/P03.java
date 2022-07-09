package finalExam;

import java.util.*;
import java.util.stream.Collectors;

public class P03 {
    static Map<String, List<String>> dictionary = new LinkedHashMap<>();
    static List<String> testWords = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] definitions = scanner.nextLine().split(" \\| ");
        fillDictionary(definitions);
        testWords = Arrays.stream(scanner.nextLine().split(" \\| ")).collect(Collectors.toList());
        String testMethod = scanner.nextLine();
        if (testMethod.equals("Test")) {
            Map<String, List<String>> newDictionary = new LinkedHashMap<>();
            for (Map.Entry<String, List<String>> entry : dictionary.entrySet()) {
                List<String> currentList = entry.getValue();
                currentList = currentList.stream().sorted((e1, e2) -> Integer.compare(e2.length(), e1.length())).collect(Collectors.toList());
                dictionary.put(entry.getKey(), currentList);
                if (testWords.contains(entry.getKey())) {
                    newDictionary.put(entry.getKey(),entry.getValue());
                }
            }
            dictionary=newDictionary;
            testWords.forEach(e -> {
                if(dictionary.containsKey(e)) {
                    System.out.println(e + ":");
                    List<String> defs = dictionary.get(e);
                    defs.forEach(k -> System.out.println("-" + k));
                }
            });
        } else {
            dictionary.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(e -> System.out.print(e.getKey() + " "));
        }
    }

    private static void fillDictionary(String[] definitions) {
        for (String definition : definitions) {
            if(!definition.contains(":")){
                return;
            }
            String key = definition.split(": ")[0];
            String def = definition.split(": ")[1];
            if (dictionary.containsKey(key)) {
                List<String> currentDefs = dictionary.get(key);
                currentDefs.add(def);
                dictionary.put(key, currentDefs);
            }
            dictionary.putIfAbsent(key, new ArrayList<>() {{
                add(def);
            }});
        }
    }


}
