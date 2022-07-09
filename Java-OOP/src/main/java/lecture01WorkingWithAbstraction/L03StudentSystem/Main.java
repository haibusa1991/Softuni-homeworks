package lecture01WorkingWithAbstraction.L03StudentSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentSystem studentSystem = new StudentSystem();
        String input = scanner.nextLine();
        while (!input.equals("Exit")) {
            String[] tokens = input.split(" ");
            switch (tokens[0]) {

                case "Create":
                    studentSystem.createStudent(tokens[1],
                            Integer.parseInt(tokens[2]),
                            Double.parseDouble(tokens[3]));
                    break;

                case "Show":
                    String result = studentSystem.getStudentInfo(tokens[1]);
                    if (result != null) {
                        System.out.println(result);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
    }
}
