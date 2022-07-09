package lecture03;

import java.util.Scanner;

public class L12TradeCommissions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String city = scanner.nextLine();
        double sales = Double.parseDouble(scanner.nextLine());


        boolean isInputInvalid = false;
        double bracket1 = 0.05; // 0 <= sales <= 500
        double bracket2 = 0.07; // 500 < sales <= 1 000
        double bracket3 = 0.08; //1 000 < sales <= 10 000
        double bracket4 = 0.12; //sales > 10 000

        switch (city) {
            case "Sofia":
                break;
            case "Varna":
                bracket1 = 0.045; // 0 <= sales <= 500
                bracket2 = 0.075; // 500 < sales <= 1 000
                bracket3 = 0.1; //1 000 < sales <= 10 000
                bracket4 = 0.13; //sales > 10 000
                break;
            case "Plovdiv":
                bracket1 = 0.055; // 0 <= sales <= 500
                bracket2 = 0.08; // 500 < sales <= 1 000
                bracket3 = 0.12; //1 000 < sales <= 10 000
                bracket4 = 0.145; //sales > 10 000
                break;
            default:
                isInputInvalid = true;
        }

        double finalCommission = 0;

        if (sales >= 0 && sales <= 500) {
            finalCommission = sales * bracket1;

        } else if (sales > 500 && sales <= 1000) {
            finalCommission = sales * bracket2;

        } else if (sales > 1000 && sales <= 10000) {
            finalCommission = sales * bracket3;

        } else if (sales > 10000) {
            finalCommission = sales * bracket4;
        } else {
            isInputInvalid =true;
        }
        if(isInputInvalid){
            System.out.println("error");
        } else {
            System.out.printf("%.2f", finalCommission);
        }
    }
}