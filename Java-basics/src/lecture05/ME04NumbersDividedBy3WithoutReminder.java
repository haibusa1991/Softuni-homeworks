package lecture05;

public class ME04NumbersDividedBy3WithoutReminder {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0) {
                System.out.print(i);
                System.out.print("\n");
            }

        }
    }
}
