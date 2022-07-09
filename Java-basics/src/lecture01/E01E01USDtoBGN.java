package lecture01;

import java.util.Scanner;

public class E01E01USDtoBGN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double usd = Double.parseDouble(sc.nextLine());
        System.out.println(usd*1.79549);
    }
}
