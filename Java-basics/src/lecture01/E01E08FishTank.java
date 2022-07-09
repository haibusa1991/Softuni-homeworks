package lecture01;

import java.util.Scanner;

public class E01E08FishTank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = Integer.parseInt(sc.nextLine());
        int width = Integer.parseInt(sc.nextLine());
        int height = Integer.parseInt(sc.nextLine());
        double sand = Double.parseDouble(sc.nextLine());
        System.out.printf("%.2f",length*width*height*(1-sand/100)/1000);

    }
}
