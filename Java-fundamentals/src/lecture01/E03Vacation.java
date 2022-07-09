package lecture01;

import java.util.Scanner;

public class E03Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numPeople = Integer.parseInt(scanner.nextLine());
        String groupType = scanner.nextLine();
        String dayOfWeek = scanner.nextLine();

        double finalPrice = 0;
        double pricePerPerson = 0;
        switch (groupType) {
            case "Students":
                switch (dayOfWeek) {
                    case "Friday":
                        pricePerPerson = 8.45;
                        break;
                    case "Saturday":
                        pricePerPerson = 9.8;
                        break;
                    case "Sunday":
                        pricePerPerson = 10.46;
                        break;
                }
                finalPrice = numPeople * pricePerPerson;
                if (numPeople >= 30) {
                    finalPrice *= 0.85;
                }
                break;
            case "Business":
                switch (dayOfWeek) {
                    case "Friday":
                        pricePerPerson = 10.9;
                        break;
                    case "Saturday":
                        pricePerPerson = 15.6;
                        break;
                    case "Sunday":
                        pricePerPerson = 16;
                        break;
                }
                finalPrice = numPeople * pricePerPerson;
                if (numPeople >= 100) {
                    finalPrice -= 10 * pricePerPerson;
                }
                break;
            case "Regular":
                switch (dayOfWeek) {
                    case "Friday":
                        pricePerPerson = 15;
                        break;
                    case "Saturday":
                        pricePerPerson = 20;
                        break;
                    case "Sunday":
                        pricePerPerson = 22.5;
                        break;
                }
                finalPrice = numPeople * pricePerPerson;
                if (numPeople >= 10 && numPeople <= 20) {
                    finalPrice *= 0.95;
                }
                break;
        }
        System.out.printf("Total price: %.2f", finalPrice);
    }

}
