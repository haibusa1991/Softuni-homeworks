package lecture03;

import java.util.Scanner;

public class E03NewHouse {
    public static void main(String[] args) {
        Scanner scanner = new  Scanner(System.in);

        String flowerType = scanner.nextLine();
        int numOfFlower=Integer.parseInt(scanner.nextLine());
        int budget = Integer.parseInt(scanner.nextLine());

        double finalPrice=0;

        switch (flowerType){
            case "Roses":
                finalPrice=5*numOfFlower;
                if (numOfFlower>80){
                    finalPrice*=0.9;
                }
                break;
            case "Dahlias":
                finalPrice=3.8*numOfFlower;
                if (numOfFlower>90){
                    finalPrice*=0.85;
                }
                break;
            case "Tulips":
                finalPrice=2.8*numOfFlower;
                if (numOfFlower>80){
                    finalPrice*=0.85;
                }
                break;
            case "Narcissus":
                finalPrice=3*numOfFlower;
                if (numOfFlower<120){
                    finalPrice*=1.15;
                }
                break;
            case "Gladiolus":
                finalPrice=2.5*numOfFlower;
                if (numOfFlower<80){
                    finalPrice*=1.2;
                }
                break;
        }
        if(finalPrice<=budget){
            System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.",numOfFlower,flowerType,budget-finalPrice);
        }else {
            System.out.printf("Not enough money, you need %.2f leva more.",finalPrice-budget);
        }
    }
}
