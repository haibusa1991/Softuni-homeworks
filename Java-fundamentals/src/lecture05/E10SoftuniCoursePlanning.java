package lecture05;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E10SoftuniCoursePlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> course = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equalsIgnoreCase("course start")) {
            String[] arr = input.split(":");
            String command = arr[0];
            String lesson1 = "";
            switch (command) {
                case "Add":
                    lesson1 = arr[1];
                    if (!course.contains(lesson1)) {
                        course.add(lesson1);
                    }
                    break;
                case "Insert":
                    lesson1 = arr[1];
                    int index = Integer.parseInt(arr[2]);
                    if (!course.contains(lesson1)) {
                        course.add(index, lesson1);
                    }
                    break;
                case "Remove":
                    lesson1 = arr[1];
                    course.remove(lesson1);
                    String exerciseToRemove = lesson1 + "-Exercise";
                    course.remove(exerciseToRemove);
                    break;
                case "Swap":
                    lesson1 = arr[1];
                    String lesson2 = arr[2];
                    if (course.contains(lesson1) && course.contains(lesson2)) {
                        int index1 = course.indexOf(lesson1);
                        int index2 = course.indexOf(lesson2);
                        course.set(index1, lesson2);
                        course.set(index2, lesson1);
                        String exercise1 = lesson1 + "-Exercise";
                        String exercise2 = lesson2 + "-Exercise";
                        if (course.contains(exercise1)) {
                            course.remove(exercise1);
                            course.add(index2 + 1, exercise1);
                        }
                        if (course.contains(exercise2)) {
                            course.remove(exercise2);
                            course.add(index1 + 1, exercise2);
                        }
                    }
                    break;
                case "Exercise":
                    lesson1 = arr[1];
                    String exercise1 = lesson1 + "-Exercise";
                    if (course.contains(lesson1) && !course.contains(exercise1)) {
                        course.add(course.indexOf(lesson1) + 1, exercise1);
                    } else if (!course.contains(lesson1) && !course.contains(exercise1)) {
                        course.add(lesson1);
                        course.add(exercise1);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        for (int i = 0; i < course.size(); i++) {
            System.out.println(i + 1 + "." + course.get(i));
        }
    }
}
