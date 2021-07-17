package lecture02;

import java.util.Scanner;

public class ME07FlowerShop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int magnolias = Integer.parseInt(sc.nextLine());
        int hyacinths = Integer.parseInt(sc.nextLine());
        int roses = Integer.parseInt(sc.nextLine());
        int cacti = Integer.parseInt(sc.nextLine());
        double presentPrice = Double.parseDouble(sc.nextLine());

        double earnings = (magnolias * 3.25 + hyacinths * 4 + roses * 3.5 + cacti * 8) * .95;

        if (earnings >= presentPrice) {
            System.out.printf("She is left with %d leva.", (int) Math.floor(earnings - presentPrice));
        } else {
            System.out.printf("She will have to borrow %d leva.", (int) Math.ceil(presentPrice - earnings));
        }

    }
}
