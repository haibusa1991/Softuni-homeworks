package lecture04;

import java.util.Scanner;

public class E07NxNMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        System.out.println(getMatrix(n));
    }

    private static String getMatrix(int n) {
        String output = "";
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                output += n + " ";
            }
            output += "\n";
        }
        return output;
    }
}
