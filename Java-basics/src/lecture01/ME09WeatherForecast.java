package lecture01;

import java.util.Scanner;

public class ME09WeatherForecast {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String weather = sc.nextLine();
        if (weather.equalsIgnoreCase("sunny")) {
            System.out.println("It's warm outside!");
        } else {
            System.out.println("It's cold outside!");
        }

    }
}
