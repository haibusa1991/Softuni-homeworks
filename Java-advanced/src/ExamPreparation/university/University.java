package ExamPreparation.university;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class University {
    public int capacity;
    public List<Student> students;

    public University(int capacity) {
        this.capacity = capacity;
        students = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getStudentCount() {
        return students.size();
    }

    public String registerStudent(Student student) {
        Student current = getStudent(student.firstName, student.lastName);
        if (students.size() == capacity) {
            return "No seats in the university";
        }
        if (current != null) {
            return "Student is already in the university";
        }
        students.add(student);
        return String.format("Added student %s %s", student.firstName, student.lastName);
    }

    public String dismissStudent(Student student) {
        Student s;
        try {
            s = students.stream()
                    .filter(e -> e.firstName.equals(student.firstName))
                    .filter(e -> e.lastName.equals(student.lastName))
                    .collect(Collectors.toList())
                    .get(0);
        } catch (Exception e) {
            return "Student not found";
        }
        students.remove(s);
        return String.format("Removed student %s %s",s.firstName,s.lastName);
    }

    public Student getStudent(String firstName, String lastName) {
        Student student = null;
        try {
            student = students.stream()
                    .filter(e -> e.getFirstName().equals(firstName))
                    .filter(e -> e.getLastName().equals(lastName))
                    .collect(Collectors.toList())
                    .get(0);
        } catch (Exception ignored) {
        }
        return student;
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        for (Student student : students) {
            sb.append(String.format("==Student: First Name = %s, Last Name = %s, Best Subject = %s%n", student.firstName, student.lastName, student.bestSubject));
        }
        return sb.toString();
    }

}
