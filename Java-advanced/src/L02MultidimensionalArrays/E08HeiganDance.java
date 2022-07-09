package L02MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class E08HeiganDance {
    static Field field;

    //todo 26.09.21 rewrite this shit
    //todo update 26.09.21: no need to rewrite, but chill the fuck out with the objects
    public static void main(String[] args) {
        field = new Field();
        Heigan heigan = new Heigan();
        Scanner scanner = new Scanner(System.in);
        Player player = new Player(Double.parseDouble(scanner.nextLine()));

        while (!heigan.isDead || !player.isDead) {
            field.resetField();
            heigan.takeDamage(player.getDamage());
            if (player.shouldTakeCloudDamage()) {
                player.takeCloudDamage();
                if (player.isDead()) {
                    break;
                }
            }
            if (heigan.isDead()) {
                break;
            }
            heigan.castSpell(scanner.nextLine());
            field.damageField(heigan.spellTarget);
            player.evade();
            if (!player.hasEvaded()) {
                player.takeDamage(heigan.spellDamage, heigan.isCloudDamage);
            }
            if (player.isDead()) {
                break;
            }
        }
        if (heigan.isDead()) {
            System.out.println("Heigan: Defeated!");
        } else {
            System.out.printf("Heigan: %.2f\n", heigan.getHealth());
        }

        if (player.isDead) {
            System.out.printf("Player: Killed by %s\n", player.killedBy);
        } else {
            System.out.printf("Player: %d\n", player.getHealth());
        }

        System.out.println("Final position: " + player.getLocation());
    }

    private static class Field {
        int[][] field = new int[15][15];

        public Field() {
            initField();
        }

        public void resetField() {
            initField();
        }

        private void initField() {
            for (int i = 0; i < 15; i++) {
                Arrays.fill(field[i], 1);
            }
        }

        public void damageField(int[] target) {
            int startRow = target[0] - 1;
            int endRow = startRow + 2;
            int startColumn = target[1] - 1;
            int endColumn = startColumn + 2;
            for (int i = startRow; i <= endRow; i++) {
                for (int j = startColumn; j <= endColumn; j++) {
                    if (isValidIndex(i, j)) {
                        this.field[i][j] = 0;
                    }
                }
            }
        }

        public boolean isDamagedCell(int[] coordinates) {
            if (!isValidIndex(coordinates[0], coordinates[1])) {
                return false;
            }
            return field[coordinates[0]][coordinates[1]] == 0;
        }

        private boolean isValidIndex(int r, int c) {
            return !(r < 0
                    || r > 14
                    || c < 0
                    || c > 14);
        }

    }

    private static class Player {
        private int health = 18500;
        private final double damage;
        private int[] location = {7, 7};
        private boolean isDead = false;
        private boolean shouldTakeCloudDamage = false;
        private int cloudDamage;
        private String killedBy;

        public Player(double damage) {
            this.damage = damage;
        }

        public double getDamage() {
            return damage;
        }

        public boolean isDead() {
            return this.isDead;
        }

        public void evade() {
            if (field.isDamagedCell(location)) {
                int[] up = new int[]{location[0] - 1, location[1]};
                int[] right = new int[]{location[0], location[1] + 1};
                int[] down = new int[]{location[0] + 1, location[1]};
                int[] left = new int[]{location[0], location[1] - 1};
                if (isValidLocation(up) && !field.isDamagedCell(up)) {
                    location = up;
                } else if (isValidLocation(right) && !field.isDamagedCell(right)) {
                    location = right;
                } else if (isValidLocation(down) && !field.isDamagedCell(down)) {
                    location = down;
                } else if (isValidLocation(left) && !field.isDamagedCell(left)) {
                    location = left;
                }
            }
        }

        private boolean isValidLocation(int[] location) {
            return !(location[0] < 0
                    || location[0] > 14
                    || location[1] < 0
                    || location[1] > 14);
        }

        public boolean hasEvaded() {
            return !field.isDamagedCell(location);
        }

        public void takeDamage(int damage, boolean isCloudDamage) {
            health -= damage;
            if (health <= 0) {
                isDead = true;
                if (isCloudDamage) {
                    killedBy = "Plague Cloud";
                } else {
                    killedBy = "Eruption ";
                }
            }
            shouldTakeCloudDamage = isCloudDamage;
            this.cloudDamage = damage;
        }

        public void takeCloudDamage() {
            health -= cloudDamage;
            if (health <= 0) {
                isDead = true;
                killedBy = "Plague Cloud";
            }
            shouldTakeCloudDamage = false;
        }

        public boolean shouldTakeCloudDamage() {
            return this.shouldTakeCloudDamage;
        }

        public int getHealth() {
            return this.health;
        }

        public String getLocation() {
            return "" + location[0] + ", " + location[1];
        }
    }

    private static class Heigan {
        private double health = 3000000;
        private final int cloudDamage = 3500;
        private final int eruptionDamage = 6000;
        private boolean isDead = false;
        private int[] spellTarget;
        private String spellName;
        private int spellDamage;
        private boolean isCloudDamage;

        public void takeDamage(double damage) {
            health -= damage;
            if (health <= 0) {
                isDead = true;
            }
        }

        public double getHealth() {
            return this.health;
        }

        public void castSpell(String spell) {
            String[] input = spell.split(" ");
            this.spellName = input[0];
            int r = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);
            spellTarget = new int[]{r, c};
            setSpellDamage();
            setIfCloudDamage();
        }

        private void setSpellDamage() {
            spellDamage = spellName.equals("Cloud") ? cloudDamage : eruptionDamage;
        }

        private void setIfCloudDamage() {
            isCloudDamage = spellName.equals("Cloud");
        }

        public boolean isDead() {
            return this.isDead;
        }
    }
}

