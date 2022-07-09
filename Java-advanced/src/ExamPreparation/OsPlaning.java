package ExamPreparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class OsPlaning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> taskStack = new ArrayDeque<>();
        ArrayDeque<Integer> threadQueue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(taskStack::push);
        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).forEach(threadQueue::offer);
        int targetTask = Integer.parseInt(scanner.nextLine());
        Integer task = null;
        Integer thread = null;
        while (!threadQueue.isEmpty()) {
            task = taskStack.peek();
            thread = threadQueue.peek();
            assert !taskStack.isEmpty();

            if (task == targetTask) {
                break;
            }

            if (thread >= task) {
                taskStack.pop();
            }
            threadQueue.poll();
        }
        System.out.printf("Thread with value %d killed task %d%n", thread, task);
        while (!threadQueue.isEmpty()) {
            System.out.printf("%d ", threadQueue.poll());
        }

    }
}
