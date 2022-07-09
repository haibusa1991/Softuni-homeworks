package Workshop01.CustomStack;


import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random r = new Random();
        CustomStack customStack = new CustomStack();
        for (int i = 1; i < 10; i++) {
            customStack.push(r.nextInt(50));
        }

        customStack.forEach(System.out::println);
        System.out.println();
    }
}
