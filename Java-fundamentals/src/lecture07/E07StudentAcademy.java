package lecture07;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class E07StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Double> students = new LinkedHashMap<>();
        int numStudents = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numStudents; i++) {
            String name = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());
            if (!students.containsKey(name)) {
                students.put(name, grade);
            } else {
                students.put(name, (students.get(name) + grade) / 2);
            }
        }
        students.entrySet()
                .stream()
                .filter(e -> e.getValue() >= 4.5)
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(e -> System.out.printf("%s -> %.2f%n", e.getKey(), e.getValue()));
    }
}
