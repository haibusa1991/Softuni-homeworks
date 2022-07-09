package lecture03Inheritance.E03PlayersAndMonsters;

public class Main {
    public static void main(String[] args) {
        Knight knight = new BladeKnight("ivan",15);
        System.out.println(knight);

        Hero hero = new Hero("ff",32);
        System.out.println(hero);
    }
}
