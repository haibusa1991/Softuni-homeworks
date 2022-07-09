package finalExamExcercise;

import java.util.Scanner;

//https://judge.softuni.bg/Contests/Practice/Index/1443#0
public class FEE17SantasCookies {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());
        int totalCookies = 0;
        for (int i = 0; i < n; i++) {
            int flour = (int) Math.floor(1.0 * Integer.parseInt(scanner.nextLine()) / 140);
            int sugar = (int) Math.floor(1.0 * Integer.parseInt(scanner.nextLine()) / 20);
            int cocoa = (int) Math.floor(1.0 * Integer.parseInt(scanner.nextLine()) / 10);
            int numCookies = (int) Math.floor(6.8 * Math.min(flour, Math.min(sugar, cocoa)));
            if (numCookies < 5) {
                System.out.println("Ingredients are not enough for a box of cookies.");
            } else {
                System.out.println("Boxes of cookies: " + (numCookies / 5));
                totalCookies += numCookies / 5;
            }
        }
        System.out.println("Total boxes: "+totalCookies);
    }
}
