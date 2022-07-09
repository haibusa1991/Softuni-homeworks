package L04StreamsFilesAndDirectories;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class E12CreateZipArchive {
    public static void main(String[] args) throws IOException {
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream("files.zip"));
        List<String> files = new ArrayList<>();
        files.add("outputL04-E03.txt");
        files.add("outputL04-E05.txt");
        files.add("outputL04-E07.txt");
        for (String file : files) {
            zos.putNextEntry(new ZipEntry(file));
            zos.write(new FileInputStream(file).readAllBytes());
        }
        zos.close();
    }
}
