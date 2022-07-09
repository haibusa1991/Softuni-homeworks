package finalExamExcercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

//https://judge.softuni.bg/Contests/Practice/Index/2303#2
public class FEE06HeroesOfCodeAndLogic7 {
    //heroName HP MP
    static Map<String, String> heroes = new LinkedHashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split(" ");
            String heroName = data[0];
            String health = data[1];
            String mana = data[2];
            heroes.put(heroName, health + " " + mana);
        }

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            if (input.contains("CastSpell")) {
                castSpell(input);
            } else if (input.contains("TakeDamage")) {
                takeDamage(input);
            } else if (input.contains("Recharge")) {
                recharge(input);
            } else if (input.contains("Heal")) {
                heal(input);
            }
            input = scanner.nextLine();
        }

        heroes.entrySet()
                .stream()
                .sorted((e1, e2) -> {
                    int res = Integer.compare(Integer.parseInt(e2.getValue().split(" ")[0]),
                            Integer.parseInt(e1.getValue().split(" ")[0]));
                    if (res == 0) {
                        return e1.getKey().compareTo(e2.getKey());
                    } else {
                        return res;
                    }
                })
                .forEach(e -> {
                    System.out.println(e.getKey());
                    System.out.println("  HP: " + e.getValue().split(" ")[0]);
                    System.out.println("  MP: " + e.getValue().split(" ")[1]);
                });
    }

    private static void heal(String input) {
        String[] data = input.split(" - ");
        String heroName = data[1];
        int healthPoints = Integer.parseInt(data[2]);

        int currentHealth = Integer.parseInt(heroes.get(heroName).split(" ")[0]);
        int currentMana = Integer.parseInt(heroes.get(heroName).split(" ")[1]);

        if (currentHealth + healthPoints > 100) {
            System.out.printf("%s healed for %d HP!%n", heroName, 100 - currentHealth);
            heroes.put(heroName, 100 + " " + currentMana);
        } else {
            System.out.printf("%s healed for %d HP!%n", heroName, healthPoints);
            heroes.put(heroName, (currentHealth + healthPoints) + " " + currentMana);
        }
    }

    private static void recharge(String input) {
        String[] data = input.split(" - ");
        String heroName = data[1];
        int manaPoints = Integer.parseInt(data[2]);

        int currentHealth = Integer.parseInt(heroes.get(heroName).split(" ")[0]);
        int currentMana = Integer.parseInt(heroes.get(heroName).split(" ")[1]);

        if (currentMana + manaPoints > 200) {
            System.out.printf("%s recharged for %d MP!%n", heroName, 200 - currentMana);
            heroes.put(heroName, currentHealth + " " + 200);
        } else {
            System.out.printf("%s recharged for %d MP!%n", heroName, manaPoints);
            heroes.put(heroName, currentHealth + " " + (currentMana + manaPoints));
        }
    }

    private static void takeDamage(String input) {
        String[] data = input.split(" - ");
        String heroName = data[1];
        int damage = Integer.parseInt(data[2]);
        String attacker = data[3];

        int currentHealth = Integer.parseInt(heroes.get(heroName).split(" ")[0]);
        int currentMana = Integer.parseInt(heroes.get(heroName).split(" ")[1]);

        if (damage >= currentHealth) {
            System.out.printf("%s has been killed by %s!%n", heroName, attacker);
            heroes.remove(heroName);
            return;
        }

        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n", heroName, damage, attacker, currentHealth - damage);
        heroes.put(heroName, (currentHealth - damage) + " " + currentMana);

    }

    private static void castSpell(String input) {
        String[] data = input.split(" - ");
        String heroName = data[1];
        int manaPoints = Integer.parseInt(data[2]);
        String spellName = data[3];

        int currentHealth = Integer.parseInt(heroes.get(heroName).split(" ")[0]);
        int currentMana = Integer.parseInt(heroes.get(heroName).split(" ")[1]);

        if (currentMana < manaPoints) {
            System.out.printf("%s does not have enough MP to cast %s!%n", heroName, spellName);
            return;
        }

        System.out.printf("%s has successfully cast %s and now has %d MP!%n", heroName, spellName, currentMana - manaPoints);
        heroes.put(heroName, currentHealth + " " + (currentMana - manaPoints));

    }

}
