package playground;

import java.util.Random;

class GetBitInfoTest {
//    final int NUMBER_OF_CYCLES = Integer.MAX_VALUE;
    final int NUMBER_OF_CYCLES = 50;

    @org.junit.jupiter.api.Test
    void testSpeed() {
        long timer;
        Random r = new Random();
//        r.ints(0, Integer.MAX_VALUE);
        r.ints(0, 1500);
        long modTimes = 0;
        long divTimes = 0;
        long bitTimes = 0;
        boolean result;
        for (int i = 0; i < NUMBER_OF_CYCLES; i++) {
            int testValue = Math.abs(r.nextInt());

            //modTimes
            timer = System.nanoTime();
            result = GetBitInfo.isEvenMod(testValue);
            modTimes += System.nanoTime() - timer;

            //divTimes
            timer = System.nanoTime();
            result = GetBitInfo.isEvenDiv(testValue);
            divTimes += System.nanoTime() - timer;

            //bitTimes
            timer = System.nanoTime();
            result = GetBitInfo.isEvenBits(testValue);
            bitTimes += System.nanoTime() - timer;

        }
        System.out.println("modTimes average: " + ((double) modTimes / NUMBER_OF_CYCLES) + " ns");
        System.out.println("divTimes average: " + ((double) divTimes / NUMBER_OF_CYCLES) + " ns");
        System.out.println("bitTimes average: " + ((double) bitTimes / NUMBER_OF_CYCLES) + " ns");
    }
}