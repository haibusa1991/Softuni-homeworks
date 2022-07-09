package lecture03;

import java.util.Scanner;

public class L04PersonalTitles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double age = Double.parseDouble(scanner.nextLine());
        char gender = scanner.nextLine().charAt(0);
        String title = "";

        if (gender == 'm') {
            if (age < 16) {
                title = "Master";
            } else {
                title = "Mr.";
            }
        } else {
            if (age < 16) {
                title = "Miss";
            } else {
                title = "Ms.";
            }
        }
        System.out.println(title);
    }
}
