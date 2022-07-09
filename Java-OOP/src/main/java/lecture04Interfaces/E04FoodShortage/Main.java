package lecture04Interfaces.E04FoodShortage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Person> buyers = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            Person buyer = null;
            String[] tokens = scanner.nextLine().split(" ");
            if (tokens.length == 3) {
                buyer = new Rebel(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
            } else if (tokens.length == 4) {
                buyer = new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2], tokens[3]);
            }

            if (buyer != null) {
                buyers.add(buyer);
            }
        }

        String currentBuyer = scanner.nextLine();
        while (!currentBuyer.equals("End")) {

            for (Person buyer : buyers) {
                if (buyer.getName().equals(currentBuyer)) {
                    ((Buyer) buyer).buyFood();
                }
            }

            currentBuyer = scanner.nextLine();
        }

        System.out.println(buyers.stream().mapToInt(e -> ((Buyer) e).getFood()).sum());

    }
}
