package L06DefiningClasses.E09CatLady;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Cat> cats = new ArrayList<>();
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] tokens = input.split(" ");
            switch (tokens[0]) {
                case "Siamese":
                    cats.add(new Siamese(tokens[1], Double.parseDouble(tokens[2])));
                    break;
                case "Cymric":
                    cats.add(new Cymric(tokens[1], Double.parseDouble(tokens[2])));
                    break;
                default:
                    cats.add(new StreetExtraordinaire(tokens[1], Double.parseDouble(tokens[2])));
            }
            input=scanner.nextLine();
        }
        String targetCat = scanner.nextLine();
        cats.stream()
                .filter(e -> e.getName().equals(targetCat))
                .forEach(System.out::println);
    }
}
