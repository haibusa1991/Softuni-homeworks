package lecture05;

import java.util.Scanner;

public class E06Cake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int w = Integer.parseInt(scanner.nextLine());
        int h = Integer.parseInt(scanner.nextLine());

        int numPieces = w * h;
        boolean isStopped=false;

        while (numPieces>=0){
            String input = scanner.nextLine();

            if(input.equalsIgnoreCase("stop")){
                isStopped=true;
                break;
            }
            numPieces-=Integer.parseInt(input);


        }
        if(!isStopped){
            System.out.printf("No more cake left! You need %d pieces more.",Math.abs(numPieces));
        }else {
            System.out.printf("%d pieces are left.",numPieces);
        }

    }
}
