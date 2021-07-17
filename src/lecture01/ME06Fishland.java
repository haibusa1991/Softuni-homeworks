package lecture01;

import java.util.Scanner;

public class ME06Fishland {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double mackerelPrice =Double.parseDouble(sc.nextLine());
        double spratPrice =  Double.parseDouble(sc.nextLine());
        double bonitoWeight = Double.parseDouble(sc.nextLine());
        double scadWeight = Double.parseDouble(sc.nextLine());
        double musselWeight = Double.parseDouble(sc.nextLine());

        System.out.printf("%.2f",bonitoWeight*mackerelPrice*1.6+scadWeight*spratPrice*1.8+musselWeight*7.5);
    }
}
