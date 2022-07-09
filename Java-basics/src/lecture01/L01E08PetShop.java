package lecture01;

import java.util.Scanner;

public class L01E08PetShop {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfDogs = Integer.parseInt(sc.nextLine());
        int numOfOtherAnimals = Integer.parseInt(sc.nextLine());

        System.out.printf("%.1f lv.", numOfDogs*2.5+numOfOtherAnimals*4);
    }
}


