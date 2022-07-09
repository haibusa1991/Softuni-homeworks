package lecture06.E02Articles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(", ");
        Article article = new Article(input[0], input[1], input[2]);

        int numCommands = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numCommands; i++) {
            String[] currentCommand = scanner.nextLine().split(": ");

            switch (currentCommand[0]) {
                case "Edit":
                    article.editContent(currentCommand[1]);
                    break;
                case "ChangeAuthor":
                    article.changeAuthor(currentCommand[1]);
                    break;
                case "Rename":
                    article.renameArticle(currentCommand[1]);
                    break;
            }
        }
        System.out.println(article);
    }
}
