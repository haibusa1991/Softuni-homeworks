package L03SetsAndMapsAdvanced;

import java.util.*;

public class L05AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<Double>> records = new TreeMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            String name = tokens[0];
            double grade = Double.parseDouble(tokens[1]);
            records.putIfAbsent(name, new ArrayList<>());
            records.get(name).add(grade);
        }
        records.forEach((name, grades) -> {
            System.out.print(name + " -> ");
            grades.forEach(k -> System.out.printf("%.2f ", k));
            double averageGrade = 0;
            for (double grade : grades) {
                averageGrade += grade;
            }
            System.out.print("");
            averageGrade /= grades.size();
            double average = grades.stream().mapToDouble(e->e).average().orElse(Double.NaN);
            System.out.printf("(avg: %.2f)", average);
            System.out.println();
        });
    }
}
