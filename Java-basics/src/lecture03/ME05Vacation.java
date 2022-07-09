package lecture03;

import java.util.Scanner;

public class ME05Vacation {
    public static void main(String[] args) {
        Scanner scanner = new  Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();
        boolean isSummer = season.equals("Summer");

        double price;

        String destination="Morocco";
        String location;

        if(isSummer){
            destination="Alaska";
        }

        if (budget<=1000){
            location="Camp";

            if (isSummer){
                price=0.65;
            } else {
                price=0.45;
            }

        } else if (budget<=3000){
            location="Hut";

            if (isSummer){
                price=0.8;
            } else {
                price=0.6;
            }
        }else {
            location="Hotel";
            price=0.9;
        }
        System.out.printf("%s - %s - %.2f",destination,location,price*budget);
    }

}
