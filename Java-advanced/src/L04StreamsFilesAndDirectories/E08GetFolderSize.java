package L04StreamsFilesAndDirectories;

import java.io.File;
import java.util.ArrayDeque;

public class E08GetFolderSize {
    public static void main(String[] args) {
        int size = 0;
        ArrayDeque<String> folders = new ArrayDeque<>();
        folders.offer("D:\\Repos\\SoftUni\\Java-advanced\\src\\L04StreamsFilesAndDirectories\\ExerciseFiles\\Exercises Resources");
        while (!folders.isEmpty()) {
            File files = new File(folders.poll());
            for (File f : files.listFiles()) {
                if(f.isDirectory()){
                    folders.offer(f.getPath());
                }else {
                    size+=f.length();
                }
            }
        }
        System.out.println("Folder size: "+size);


    }

}
