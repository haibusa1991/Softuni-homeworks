package lecture05;

import java.util.Scanner;

public class E01OldBooks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String book = scanner.nextLine();
//        boolean isFound = false;
        int numBooksChecked = 0;

        while (true) {
            String currentBook = scanner.nextLine();


            if (currentBook.equals(book)) {
                System.out.printf("You checked %d books and found it.", numBooksChecked);
                break;
            }

            if (currentBook.equalsIgnoreCase("No More Books")) {
                System.out.printf("The book you search is not here!\nYou checked %d books.", numBooksChecked);
                break;
            }
            numBooksChecked++;
        }

    }
}
