package lecture06.L06Students2;

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
            if (isExistingStudent(data[0], data[1], students)) {
                for (Student student : students) {
                    if (student.equals(getStudent(data[0], data[1], students))) {
                        student.updateInfo(data[0], data[1], Integer.parseInt(data[2]), data[3]);
                    }
                }
            } else {
                students.add(new Student(data[0], data[1], Integer.parseInt(data[2]), data[3]));
            }
            input = scanner.nextLine();
        }

        String hometown = scanner.nextLine();
        List<Student> filteredList = students.stream().filter(e -> e.getHometown().equals(hometown)).collect(Collectors.toList());
        for (Student currentStudent : filteredList) {
            System.out.println(currentStudent);
        }
    }

    public static boolean isExistingStudent(String firstName, String lastName, List<Student> list) {

        for (Student student : list) {
            if (firstName.equals(student.getFirstName())
                    && lastName.equals(student.getLastName())) {
                return true;
            }
        }
        return false;
    }

    public static Student getStudent(String firstName, String lastName, List<Student> list) {
        for (Student student : list) {
            if (firstName.equals(student.getFirstName())
                    && lastName.equals(student.getLastName())) {
                return student;
            }
        }
        return null;
    }
}
