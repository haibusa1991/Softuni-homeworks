package lecture02;

import java.util.Scanner;

public class L11RefactorVolumeOfPyramid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Length: ");
        double length = 0;
        length = Double.parseDouble(scanner.nextLine());

        System.out.print("Width: ");
        double width = 0;
        width = Double.parseDouble(scanner.nextLine());

        System.out.print("Height: ");
        double height = 0;
        height = Double.parseDouble(scanner.nextLine());

        double volume = 0;
        volume = (length * width * height) / 3;
        System.out.printf("Pyramid Volume: %.2f", volume);

    }
}
