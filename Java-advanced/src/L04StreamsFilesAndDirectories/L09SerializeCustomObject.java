package L04StreamsFilesAndDirectories;

import java.io.*;

public class L09SerializeCustomObject {
    private static class Cube implements Serializable {
        private String color;
        private double width;
        private double height;
        private double depth;


        public Cube(String color, double width, double height, double depth) {
            this.color = color;
            this.width = width;
            this.height = height;
            this.depth = depth;
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Cube cube = new Cube("green", 15.3, 12.4, 3);
        String cubePath = "D:\\Repos\\SoftUni\\Java-advanced\\src\\L04StreamsFilesAndDirectories\\LabFiles\\09.SerializeCustomObject.txt";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(cubePath));
        oos.writeObject(cube);

        Cube cube2 = (Cube) new ObjectInputStream(new FileInputStream(cubePath)).readObject();
    }

}
