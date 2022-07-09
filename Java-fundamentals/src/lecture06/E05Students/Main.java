package lecture06.E05Students;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Student> students = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            students.add(new Student(input[0], input[1], Double.parseDouble(input[2])));
        }

        students.sort(Comparator.comparing(Student::getGrade));
        Collections.reverse(students);

        students.forEach(System.out::println);

    }
}
