package lecture01;

import java.util.Scanner;

public class ME07HousePainting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double x = Double.parseDouble(sc.nextLine());
        double y = Double.parseDouble(sc.nextLine());
        double h = Double.parseDouble(sc.nextLine());

        double greenArea = 2*x*(x+y)-1.2*2-1.5*1.5*2;
        double redArea = 2*x*y+2*h*x/2;

        System.out.printf("%.2f\n%.2f",greenArea/3.4,redArea/4.3);
    }
}
