package lecture02;

import java.util.Scanner;

public class E02BonusScore {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int startingScore = Integer.parseInt(sc.nextLine());
        double bonusScore=0.0;

        if (startingScore<=100){
            bonusScore+=5;
        } else if (startingScore<=1000) {
            bonusScore += startingScore * .2;
        } else {
            bonusScore +=startingScore*.1;
        }

        if (startingScore==(startingScore/2)*2){
            bonusScore+=1;
        }

        if (startingScore%10==5){
            bonusScore+=2;
        }

        System.out.printf("%.1f\n%.1f",bonusScore,startingScore+bonusScore);
    }
}
