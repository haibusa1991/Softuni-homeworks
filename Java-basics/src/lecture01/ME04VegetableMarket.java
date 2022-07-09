package lecture01;

import java.util.Scanner;

public class ME04VegetableMarket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double vegPrice = Double.parseDouble(sc.nextLine());
        double fruitPrice = Double.parseDouble(sc.nextLine());
        int vegWeight = Integer.parseInt(sc.nextLine());
        int fruitWeight = Integer.parseInt(sc.nextLine());

        System.out.printf("%.2f",(vegPrice*vegWeight+fruitPrice*fruitWeight)/1.94);

    }
}
