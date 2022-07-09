package lecture01;

import java.util.Scanner;

public class L05MonthPrinter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int month = Integer.parseInt(scanner.nextLine());
        String value;
        switch (month) {
            case 1:
                value = "January";
                break;
            case 2:
                value = "February";
                break;
            case 3:
                value = "March";
                break;
            case 4:
                value = "April";
                break;
            case 5:
                value = "May";
                break;
            case 6:
                value = "June";
                break;
            case 7:
                value = "July";
                break;
            case 8:
                value = "August";
                break;
            case 9:
                value = "September";
                break;
            case 10:
                value = "October";
                break;
            case 11:
                value = "November";
                break;
            case 12:
                value = "December";
                break;
            default:
                value = "Error!";
                break;
        }
        System.out.println(value);
    }
}
