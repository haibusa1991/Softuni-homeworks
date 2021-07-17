package lecture02;

import java.util.Scanner;

public class L06AreaOfFigures {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String figureType = sc.nextLine();

        if (figureType.equals("square")) {
            double side = Double.parseDouble(sc.nextLine());
            System.out.printf("%.3f", side * side);

        }else if(figureType.equals("rectangle")) {
            double sideA = Double.parseDouble(sc.nextLine());
            double sideB = Double.parseDouble(sc.nextLine());
            System.out.printf("%.3f", sideA * sideB);

        }else if (figureType.equals("circle")) {
            double radius = Double.parseDouble(sc.nextLine());
            System.out.printf("%.3f", Math.PI * radius * radius);

        }else if (figureType.equals("triangle")) {
            double side = Double.parseDouble(sc.nextLine());
            double height = Double.parseDouble(sc.nextLine());
            System.out.printf("%.3f", side*height/2);
        }
    }
}
