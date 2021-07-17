package lecture04;

import java.util.Scanner;

public class ME07FootballLeague {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int capacity = Integer.parseInt(scanner.nextLine());
        int numFans = Integer.parseInt(scanner.nextLine());

        int sectorAFans = 0;
        int sectorBFans = 0;
        int sectorVFans = 0;
        int sectorGFans = 0;

        for (int i = 0; i < numFans; i++) {

            char sector = scanner.nextLine().charAt(0);

            switch (sector) {
                case 'A':
                    sectorAFans++;
                    break;
                case 'B':
                    sectorBFans++;
                    break;
                case 'V':
                    sectorVFans++;
                    break;
                case 'G':
                    sectorGFans++;
                    break;
            }

        }
        System.out.printf("%.2f%%%n",1.0*sectorAFans/numFans*100);
        System.out.printf("%.2f%%%n",1.0*sectorBFans/numFans*100);
        System.out.printf("%.2f%%%n",1.0*sectorVFans/numFans*100);
        System.out.printf("%.2f%%%n",1.0*sectorGFans/numFans*100);
        System.out.printf("%.2f%%",1.0*numFans/capacity*100);
    }
}
