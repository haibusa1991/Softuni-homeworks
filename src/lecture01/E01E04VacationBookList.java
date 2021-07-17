package lecture01;

import java.util.Scanner;

public class E01E04VacationBookList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pages = Integer.parseInt(sc.nextLine());
        int pagesPerHour = Integer.parseInt(sc.nextLine());
        int days = Integer.parseInt(sc.nextLine());
        System.out.println(pages/pagesPerHour/days);
    }
}
