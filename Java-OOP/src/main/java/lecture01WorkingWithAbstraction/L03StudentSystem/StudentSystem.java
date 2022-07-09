package lecture01WorkingWithAbstraction.L03StudentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private final Map<String, Student> students;

    public StudentSystem() {
        this.students = new HashMap<>();
    }

    public Map<String, Student> getStudents() {
        return this.students;
    }

    public void createStudent(String name, int age, double grade) {
        students.putIfAbsent(name, new Student(name, age, grade));
    }

    public String getStudentInfo(String studentName) {
        if (students.containsKey(studentName)) {
            Student student = students.get(studentName);
            return String.format("%s is %s years old. %s", student.getName(), student.getAge(), getComment(student.getGrade()));
        }
        return null;
    }

    private String getComment(double grade) {
        if (grade >= 5.00) {
            return "Excellent student.";
        } else if (grade >= 3.50) {
            return "Average student.";
        }
        return "Very nice person.";
    }
}
