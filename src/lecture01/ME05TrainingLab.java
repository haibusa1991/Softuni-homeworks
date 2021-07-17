package lecture01;

import java.util.Scanner;

public class ME05TrainingLab {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double w = Double.parseDouble(sc.nextLine());
        double h = Double.parseDouble(sc.nextLine());
        System.out.println((((int) ((h - 1) / .7)) * ((int) (w / 1.2))) - 3);
    }
}
