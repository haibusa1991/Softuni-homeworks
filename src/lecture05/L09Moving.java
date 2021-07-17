package lecture05;

import java.util.Scanner;

public class L09Moving {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int w = Integer.parseInt(scanner.nextLine());
        int l = Integer.parseInt(scanner.nextLine());
        int h = Integer.parseInt(scanner.nextLine());

        int freeVolume = w * l * h;

        while (true) {
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("done")){
                System.out.printf("%d Cubic meters left.",freeVolume);
                break;
            }

            if(Integer.parseInt(input)>freeVolume){
                System.out.printf("No more free space! You need %d Cubic meters more.",Integer.parseInt(input)-freeVolume);
                break;
            }
            freeVolume-=Integer.parseInt(input);
        }
    }
}
