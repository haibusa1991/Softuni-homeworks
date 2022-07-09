package lecture07;

import java.util.*;

public class E06Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, List<String>> classes = new LinkedHashMap<>();
        while (!input.equals("end")) {
            String course = input.split(" : ")[0];
            String student = input.split(" : ")[1];
            if (!classes.containsKey(course)) {
                classes.put(course, new ArrayList<>() {{
                    add(student);
                }});
            } else {
                List<String> currentClass = classes.get(course);
                currentClass.add(student);
                classes.put(course, currentClass);
            }
            input = scanner.nextLine();
        }
        classes.entrySet()
                .stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue().size(),e1.getValue().size()))
                .forEach(e->{
                    System.out.println(e.getKey() +": " + e.getValue().size());
                    e.getValue()
                            .stream()
                            .sorted()
                            .forEach(s-> System.out.println("-- " + s));
                });
    }
}
