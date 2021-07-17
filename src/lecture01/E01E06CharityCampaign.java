package lecture01;

import java.util.Scanner;

public class E01E06CharityCampaign {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int days = Integer.parseInt(sc.nextLine());
        int participants = Integer.parseInt(sc.nextLine());
        int cakes = Integer.parseInt(sc.nextLine());
        int waffles = Integer.parseInt(sc.nextLine());
        int pancakes = Integer.parseInt(sc.nextLine());
        System.out.printf("%.2f",((cakes*45+waffles*5.8+pancakes*3.2)*days*participants)*7/8);
    }
}
