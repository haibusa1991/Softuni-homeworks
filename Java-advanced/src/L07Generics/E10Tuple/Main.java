package L07Generics.E10Tuple;

import L07Generics.Generics.Tuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tokens1 = scanner.nextLine().split(" ");
        String fullName = tokens1[0] + " " + tokens1[1];
        String address = tokens1[2];
        Tuple<String, String> tuple1 = new Tuple<>(fullName, address);
        System.out.println(tuple1.print());

        String[] tokens2 = scanner.nextLine().split(" ");
        String name = tokens2[0];
        int beerAmount = Integer.parseInt(tokens2[1]);
        Tuple<String, Integer> tuple2 = new Tuple<>(name, beerAmount);
        System.out.println(tuple2.print());

        String[] tokens3 = scanner.nextLine().split(" ");
        int someInt = Integer.parseInt(tokens3[0]);
        double someDou = Double.parseDouble(tokens3[1]);
        Tuple<Integer, Double> tuple3 = new Tuple<>(someInt, someDou);
        System.out.println(tuple3.print());


    }
}
