package L03SetsAndMapsAdvanced;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class L01ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Set<String> lot = new LinkedHashSet<>();
        while (!input.equals("END")) {
            String[] data = input.split(", ");
            String action = data[0];
            String number = data[1];

            if(action.equals("IN")){
                lot.add(number);
            }else {
                lot.remove(number);
            }
            input=scanner.nextLine();
        }
        if(lot.isEmpty()){
            System.out.println("Parking Lot is Empty");
        }else {
            lot.forEach(System.out::println);
        }
    }
}
