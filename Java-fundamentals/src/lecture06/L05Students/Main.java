package lecture06.L05Students;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Student> students = new ArrayList<>();
        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] data = input.split("\\s+");
            students.add(new Student(data[0], data[1], Integer.parseInt(data[2]), data[3]));
            input = scanner.nextLine();
        }

        String hometown = scanner.nextLine();
        List<Student> filteredList = students.stream().filter(e -> e.getHometown().equals(hometown)).collect(Collectors.toList());
        for (Student currentStudent : filteredList) {
            System.out.println(currentStudent);
        }
    }
}
