package lecture01;

import java.util.Scanner;

public class L01E03SquareArea {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int side = Integer.parseInt(sc.nextLine());
        System.out.println(side*side);
    }
}
