package L04StreamsFilesAndDirectories;

import java.io.File;
import java.util.ArrayDeque;

public class L08NestedFolders {
    public static void main(String[] args) {
        int numFolders = 1;
        ArrayDeque<String> queue = new ArrayDeque<>();
        queue.offer("D:\\Repos\\SoftUni\\Java-advanced\\src\\L04StreamsFilesAndDirectories\\LabFiles\\Files-and-Streams");
        while (!queue.isEmpty()) {
            String currentPath = queue.poll();
            File files = new File(currentPath);
            System.out.println(files.getName());
            for(File file :files.listFiles()){
                if(file.isDirectory()){
                    queue.offer(file.getAbsolutePath());
                    numFolders++;
                }
            }
        }

        System.out.println(numFolders + " folders");
    }
}
