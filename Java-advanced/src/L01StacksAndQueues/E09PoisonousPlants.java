package L01StacksAndQueues;

import java.util.*;

public class E09PoisonousPlants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] initialPlants = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> plants = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            plants.push(initialPlants[i]);
        }
        plants.offer(-1);
        int numDays = 0;
        int deadPlantsToday = 0;
        while (true) {
            int currentPlant = plants.poll();
            if (plants.peek() != -1 && currentPlant <= plants.peek()) { //current plant is not the last plant for the day and is healthy
                plants.offer(currentPlant);
            } else if (plants.peek() != -1 && currentPlant > plants.peek()) { //current plant is not the last plant for the day and is not healthy
                deadPlantsToday++;
            } else if (plants.peek() == -1) {
                plants.offer(currentPlant);
                plants.poll();
                plants.offer(-1);
                if (deadPlantsToday == 0) {
                    break;
                }
                deadPlantsToday = 0;
                numDays++;
            }
        }
        System.out.println(numDays);
    }
}
