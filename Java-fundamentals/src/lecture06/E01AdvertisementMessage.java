package lecture06;

import java.util.Random;
import java.util.Scanner;

public class E01AdvertisementMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numMessages = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numMessages; i++) {
            System.out.println(getMessage());
        }
    }

    private static String getPhrase() {
        String[] messages = {"Excellent product.",
                "Such a great product.",
                "I always use that product.",
                "Best product of its category.",
                "Exceptional product.",
                "I can’t live without this product."};

        return messages[new Random().nextInt(messages.length)];
    }

    private static String getEvent() {
        String[] events = {"Now I feel good.",
                "I have succeeded with this product.",
                "Makes miracles. I am happy of the results!",
                "I cannot believe but now I feel awesome.",
                "Try it yourself, I am very satisfied.",
                "I feel great!"};
        return events[new Random().nextInt(events.length)];
    }

    private static String getAuthor() {
        String[] authors = {"Diana",
                "Petya",
                "Stella",
                "Elena",
                "Katya",
                "Iva",
                "Annie",
                "Eva"};

        return authors[new Random().nextInt(authors.length)];
    }

    private static String getCity() {
        String[] cities = {"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};

        return cities[new Random().nextInt(cities.length)];
    }

    private static String getMessage() {
        return getPhrase() + " " + getEvent() + " " + getAuthor() + " - " + getCity() + ".";
    }
}
