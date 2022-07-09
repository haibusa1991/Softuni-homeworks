package lecture08;

import java.util.Scanner;

public class L03Substring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String entryToRemove=scanner.nextLine();
        StringBuilder sb = new StringBuilder(scanner.nextLine());
        while (sb.indexOf(entryToRemove)!=-1) {
            sb.replace(sb.indexOf(entryToRemove), sb.indexOf(entryToRemove) + entryToRemove.length(), "");
        }
        System.out.println(sb);
    }
}
