package lecture01;

import java.util.Scanner;

public class L01E09YardGreening {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double area = Double.parseDouble(sc.nextLine());
        double price = area * 7.61;
        System.out.printf("The final price is: %.2f lv.\n",price*(1-.18));
        System.out.printf("The discount is: %.2f lv.\n",price*.18);
    }
}
