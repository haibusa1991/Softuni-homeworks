package L04StreamsFilesAndDirectories;

import java.io.*;

public class E11SerializeCustomObject {

    private static class Course implements Serializable {
        private final String courseName = "Java advanced";
        private final int numStudents = 26;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Course course = new Course();
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("course.ser"));
        oos.writeObject(course);

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("course.ser"));
        Course course2 = (Course) ois.readObject();
        System.out.println();
    }
}
