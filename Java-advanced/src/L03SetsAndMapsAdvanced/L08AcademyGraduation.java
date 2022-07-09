package L03SetsAndMapsAdvanced;

import java.util.*;

public class L08AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, double[]> students = new TreeMap<>();
        while (n-- > 0) {
            String name = scanner.nextLine();
            double[] grades = Arrays.stream(scanner.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
            students.put(name, grades);
        }
        students.forEach((name, grades) -> {
            double averageGrade = 0;
            for (double grade : grades) {
                averageGrade += grade;
            }
            averageGrade /= grades.length;
            System.out.println(name + " is graduated with " + averageGrade);
        });
    }
}
