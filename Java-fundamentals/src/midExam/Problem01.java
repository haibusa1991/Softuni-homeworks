package midExam;

import java.util.Scanner;

public class Problem01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int biscuitsPerDay = Integer.parseInt(scanner.nextLine());
        int numWorkers = Integer.parseInt(scanner.nextLine());
        int rivalFactoryBiscuits = Integer.parseInt(scanner.nextLine());

        int numBiscuitsPerDay = 30 * 2 / 3 * numWorkers * biscuitsPerDay;
        int numBiscuitsSlowDay = 30 / 3 * (int) Math.floor(0.75 * numWorkers * biscuitsPerDay);
        int producedBiscuits = numBiscuitsPerDay + numBiscuitsSlowDay;

        double percentage;
        if (rivalFactoryBiscuits > producedBiscuits) {
            percentage = 1.0 * (rivalFactoryBiscuits - producedBiscuits) / rivalFactoryBiscuits * 100;
//            percentage = (1 - 1.0 * producedBiscuits / rivalFactoryBiscuits) * 100;
            System.out.printf("You have produced %d biscuits for the past month.\nYou produce %.2f percent less biscuits.\n", producedBiscuits, percentage);
        } else {
            percentage = 1.0 * (producedBiscuits - rivalFactoryBiscuits) / rivalFactoryBiscuits * 100;
//            percentage = (1 - 1.0 * rivalFactoryBiscuits / producedBiscuits) * 100;
            System.out.printf("You have produced %d biscuits for the past month.\nYou produce %.2f percent more biscuits.\n", producedBiscuits, percentage);
        }

    }
}
