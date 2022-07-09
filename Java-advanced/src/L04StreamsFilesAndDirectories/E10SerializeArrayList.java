package L04StreamsFilesAndDirectories;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class E10SerializeArrayList {
    public static void main(String[] args) throws IOException {
        Random random = new Random();
        List<Double> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            list.add(random.nextDouble());
        }
        ObjectOutputStream fos = new ObjectOutputStream(new FileOutputStream("list.ser"));
        fos.writeObject(list);
    }
}
