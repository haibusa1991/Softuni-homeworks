package lecture01;

import java.util.Scanner;

public class E01E07FruitMarket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double strawberriesPrice = Double.parseDouble(sc.nextLine());
        double bananas = Double.parseDouble(sc.nextLine());
        double oranges = Double.parseDouble(sc.nextLine());
        double raspberries = Double.parseDouble(sc.nextLine());
        double strawberries = Double.parseDouble(sc.nextLine());
        System.out.printf("%.2f",bananas*strawberriesPrice*.2*.5+oranges*strawberriesPrice*.6*.5+
                raspberries*strawberriesPrice*.5+strawberries*strawberriesPrice);
    }
}
