package L03SetsAndMapsAdvanced;
import java.util.Scanner;

public class E07FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        while (!name.equals("stop")) {
            String email = scanner.nextLine();
            if (!email.endsWith("us")
                    && !email.endsWith("uk")
                    && !email.endsWith("com")) {
                System.out.println(name + " -> " + email);
            }
            name = scanner.nextLine();
        }
    }
}
