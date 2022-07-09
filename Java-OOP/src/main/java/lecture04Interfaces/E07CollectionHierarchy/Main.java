package lecture04Interfaces.E07CollectionHierarchy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] items = scanner.nextLine().split(" ");
        int countRemoves = Integer.parseInt(scanner.nextLine());

        AddCollection addCollection = new AddCollection();
        AddRemoveCollection addRemoveCollection = new AddRemoveCollection();
        MyListImpl myList = new MyListImpl();

        for (String item : items) {
            System.out.print(addCollection.add(item) + " ");
        }
        System.out.println();

        for (String item : items) {
            System.out.print(addRemoveCollection.add(item) + " ");
        }
        System.out.println();

        for (String item : items) {
            System.out.print(myList.add(item) + " ");
        }
        System.out.println();

        for (int i = 0; i < countRemoves; i++) {
            System.out.print(addRemoveCollection.remove() + " ");
        }
        System.out.println();
        for (int i = 0; i < countRemoves; i++) {
            System.out.print(myList.remove() + " ");
        }
        System.out.println();
    }
}
