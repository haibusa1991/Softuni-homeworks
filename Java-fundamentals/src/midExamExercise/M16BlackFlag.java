package midExamExercise;
//https://judge.softuni.bg/Contests/Practice/Index/1773#0

import java.util.Scanner;

public class M16BlackFlag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int daysPirating = Integer.parseInt(scanner.nextLine());
        int dailyPlunder = Integer.parseInt(scanner.nextLine());
        double expectedPlunder = Double.parseDouble(scanner.nextLine());

        double plunder = 0;
        for (int i = 1; i <= daysPirating; i++) {
            plunder += dailyPlunder;
            if (i % 3 == 0) {
                plunder += dailyPlunder * 0.5;
            }
            if (i % 5 == 0) {
                plunder *= 0.7;
            }
        }
        if(plunder>=expectedPlunder){
            System.out.printf("Ahoy! %.2f plunder gained.",plunder);
        }else {
            System.out.printf("Collected only %.2f%% of the plunder.",plunder/expectedPlunder*100);
        }
    }
}
