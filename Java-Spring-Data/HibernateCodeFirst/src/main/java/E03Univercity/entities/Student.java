package E03Univercity.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Student extends BasePerson{

    @Column (name = "average_grade")
    private double averageGrade;

    @Enumerated(value = EnumType.STRING)
    private Attendance attendance;

    @ManyToMany(mappedBy = "students")
    private Set<Course> courses = new HashSet<>();

    public Student() {
    }

    public Student(String firstName, String lastName, String phoneNumber) {
        super(firstName, lastName, phoneNumber);
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }

    public Attendance getAttendance() {
        return attendance;
    }

    public void setAttendance(Attendance attendance) {
        this.attendance = attendance;
    }

}
