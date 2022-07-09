package L04StreamsFilesAndDirectories;

import java.io.*;

public class L05WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("D:\\Repos\\SoftUni\\Java-advanced\\src\\L04StreamsFilesAndDirectories\\LabFiles\\input.txt"));
        FileWriter fw = new FileWriter("D:\\Repos\\SoftUni\\Java-advanced\\src\\L04StreamsFilesAndDirectories\\LabFiles\\05.WriteEveryThirdLineOutput.txt");
        int l = -1;
        String line = reader.readLine();
        l++;
        while (line != null) {
            if (l == 2) {
                fw.write(line+System.lineSeparator());
                l=-1;
            }
            l++;
            line = reader.readLine();
        }
        fw.close();
    }
}
