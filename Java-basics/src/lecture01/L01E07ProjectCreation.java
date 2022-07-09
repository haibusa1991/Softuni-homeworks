package lecture01;

import java.util.Scanner;

public class L01E07ProjectCreation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        int numOfProjects = Integer.parseInt(sc.nextLine());
        System.out.printf("The architect %s will need %d hours to complete %d project/s.", name, numOfProjects * 3, numOfProjects);
    }
}
