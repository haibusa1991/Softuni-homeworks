package L07Generics.E11Threeuple;

import L07Generics.Generics.Threeuple;
import L07Generics.Generics.Tuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tokens1 = scanner.nextLine().split(" ");
        String fullName = tokens1[0] + " " + tokens1[1];
        String address = tokens1[2];
        String town = tokens1[3];
        Threeuple<String, String, String> threeuple1 = new Threeuple<>(fullName, address, town);
        System.out.println(threeuple1.print());

        String[] tokens2 = scanner.nextLine().split(" ");
        String name = tokens2[0];
        int beerAmount = Integer.parseInt(tokens2[1]);
        boolean isDrunk = tokens2[2].equals("drunk");
        Threeuple<String, Integer, Boolean> threeuple2 = new Threeuple<>(name, beerAmount, isDrunk);
        System.out.println(threeuple2.print());

        String[] tokens3 = scanner.nextLine().split(" ");
        String bankName = tokens3[0];
        double balance = Double.parseDouble(tokens3[1]);
        String bank = tokens3[2];
        Threeuple<String, Double, String> threeuple3 = new Threeuple<>(bankName, balance, bank);
        System.out.println(threeuple3.print());
    }
}
