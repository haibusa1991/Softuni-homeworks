package lecture06.E04Articles2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Article2> articles = new ArrayList<>();
        int numArticles = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numArticles; i++) {
            String[] input = scanner.nextLine().split(", ");
            articles.add(new Article2(input[0], input[1], input[2]));
        }

        String sortCriteria = scanner.nextLine();
        switch (sortCriteria) {
            case "title":
                articles.sort(Comparator.comparing(Article2::getTitle));
                break;
            case "content":
                articles.sort(Comparator.comparing(Article2::getContent));
                break;
            case "author":
                articles.sort(Comparator.comparing(Article2::getAuthor));
                break;
        }

        for (Article2 article2 : articles) {
            System.out.println(article2);
        }
    }
}
