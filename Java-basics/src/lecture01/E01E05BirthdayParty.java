package lecture01;

import java.util.Scanner;

public class E01E05BirthdayParty {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rent = Integer.parseInt(sc.nextLine());
        System.out.println(rent + rent * (.2 + .2 * .55 + (double) 1/ 3));
    }
}
