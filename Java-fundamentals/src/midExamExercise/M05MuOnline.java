package midExamExercise;

import java.util.Scanner;

//https://judge.softuni.bg/Contests/Practice/Index/2028#1
public class M05MuOnline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dungeon = scanner.nextLine().split("\\|");
        int currentHealth = 100;
        int bitcoins = 0;
        boolean hasDied = false;
        int bestRoom = 1;
        for (int i = 0; i < dungeon.length; i++) {
            String roomContent = dungeon[i].split(" ")[0];
            int contentAmount = Integer.parseInt(dungeon[i].split(" ")[1]);

            switch (roomContent) {
                case "potion":
                    int amountToHeal=contentAmount;
                    if(contentAmount>100-currentHealth){
                        amountToHeal=100-currentHealth;
                    }
                    currentHealth += amountToHeal;
                    System.out.printf("You healed for %d hp.\nCurrent health: %d hp.\n", amountToHeal, currentHealth);
                    break;
                case "chest":
                    bitcoins += contentAmount;
                    System.out.printf("You found %d bitcoins.\n", contentAmount);
                    break;
                default:
                    currentHealth -= contentAmount;
                    if (currentHealth <= 0) {
                        hasDied = true;
                        bestRoom = i + 1;
                        System.out.printf("You died! Killed by %s.\nBest room: %d", roomContent, bestRoom);
                    } else {
                        System.out.printf("You slayed %s.\n", roomContent);
                    }
            }
            if (hasDied) {
                break;
            }
        }
        if (!hasDied) {
            System.out.printf("You've made it!\nBitcoins: %d\nHealth: %d\n", bitcoins, currentHealth);
        }
    }

}
