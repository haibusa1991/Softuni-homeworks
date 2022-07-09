package E03Univercity;

import E03Univercity.entities.Attendance;
import E03Univercity.entities.Course;
import E03Univercity.entities.Student;
import E03Univercity.entities.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class E03Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HibernateCodeFirst");
        EntityManager em = entityManagerFactory.createEntityManager();

        Student student1 = new Student("Ivan", "Ivanov", "0888 123 456");
        Student student2 = new Student("Petkan", "Ivanov", "0888 456 789");

        Teacher teacher1 = new Teacher("Drago", "Draganov", "0888 123 789", "dd@daskalo.com", 12.50);
        Teacher teacher2 = new Teacher("Nikola", "Nikov", "052 123 789", "nn@daskalo.com", 14.50);

        Course course1 = new Course("Math", "Mathematics 101", LocalDate.now(), LocalDate.of(2025, 1, 15), 10);
        Course course2 = new Course("Science", "Science 101", LocalDate.now(), LocalDate.of(2023, 6, 15), 10);
        Course course3 = new Course("Science", "Science 102", LocalDate.now(), LocalDate.of(2024, 1, 15), 15);

        student1.setAttendance(Attendance.NEVER_ATTENDED);
        student2.setAttendance(Attendance.AVERAGE);

        course1.setCourseTeacher(teacher1);
        course2.setCourseTeacher(teacher2);
        course3.setCourseTeacher(teacher2);

        course1.addStudent(student1);
        course1.addStudent(student2);

        course2.addStudent(student1);
        course2.addStudent(student2);


        em.getTransaction().begin();

        em.persist(student1);
        em.persist(student2);

        em.persist(teacher1);
        em.persist(teacher2);

        em.persist(course1);
        em.persist(course2);
        em.persist(course3);

        em.getTransaction().commit();
    }
}
