package lecture02;

import java.util.Scanner;

public class E10PokeMon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int pokePowerN = Integer.parseInt(scanner.nextLine());
        int distanceToTargetM = Integer.parseInt(scanner.nextLine());
        int exhaustionFactorY = Integer.parseInt(scanner.nextLine());

        int startingPokePowerN = pokePowerN;
        int targetsPoked = 0;
        while (pokePowerN >= distanceToTargetM) {
            pokePowerN -= distanceToTargetM;
            targetsPoked++;
            if ((pokePowerN == startingPokePowerN * 0.5) && (exhaustionFactorY != 0)) {
                pokePowerN /= exhaustionFactorY;
            }
        }
        System.out.printf("%d\n%d", pokePowerN, targetsPoked);
    }
}
