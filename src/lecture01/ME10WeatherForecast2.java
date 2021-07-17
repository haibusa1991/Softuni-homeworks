package lecture01;

import java.util.Scanner;

public class ME10WeatherForecast2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double temp = Double.parseDouble(sc.nextLine());

        if (temp >= 5 && temp <= 11.9) {
            System.out.println("Cold");
        } else if (temp >= 12 && temp <= 14.9) {
            System.out.println("Cool");
        } else if (temp >= 15 && temp <= 20) {
            System.out.println("Mild");
        } else if (temp > 20 && temp < 26) {
            System.out.println("Warm");
        } else if (temp >= 26 && temp <= 35) {
            System.out.println("Hot");
        } else {
            System.out.println("unknown");
        }
    }
}


