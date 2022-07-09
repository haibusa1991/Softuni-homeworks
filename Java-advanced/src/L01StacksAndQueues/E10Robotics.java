package L01StacksAndQueues;

import java.util.*;

public class E10Robotics {
    private static int currentTime = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] robotsInput = scanner.nextLine().split(";");
        List<Robot> robots = new ArrayList<>();
        for (String robot : robotsInput) {
            robots.add(new Robot(robot));
        }
        currentTime = timeManager.toSeconds(scanner.nextLine());
        ArrayDeque<String> conveyor = new ArrayDeque<>();
        String newItem = scanner.nextLine();
        while (!newItem.equals("End")) {
            conveyor.offer(newItem);
            newItem = scanner.nextLine();
        }

        while (!conveyor.isEmpty()) {
            currentTime++;
            boolean isQueued = false;
            String currentItem = conveyor.poll();
            for (Robot robot : robots) {
                if (!robot.isBusy()) {
                    robot.newTask(currentItem);
                    isQueued = true;
                    break;
                }
            }
            if (!isQueued) {
                conveyor.offer(currentItem);
            }
        }
    }

    private static class Robot {
        public String name;
        public int speed;
        public int taskStartTime;
        public int taskEndTime = Integer.MIN_VALUE;

        public Robot(String s) {
            this.name = s.split("-")[0];
            this.speed = Integer.parseInt(s.split("-")[1]);
        }

        public boolean isBusy() {
            return taskEndTime > currentTime;
        }

        public void newTask(String item) {
            taskStartTime = currentTime;
            taskEndTime = taskStartTime + speed;
            System.out.println(name + " - " + item + " [" + timeManager.to24hTime(taskStartTime) + "]");
        }
    }

    private static class timeManager {
        public static int toSeconds(String s) {
            return Integer.parseInt(s.split(":")[0]) * 3600 + Integer.parseInt(s.split(":")[1]) * 60 + Integer.parseInt(s.split(":")[2]);
        }

        public static String to24hTime(int n) {
            n %= 86400;
            return String.format("%02d:%02d:%02d", n / 3600, n % 3600 / 60, n % 3600 % 60);
        }
    }
}
