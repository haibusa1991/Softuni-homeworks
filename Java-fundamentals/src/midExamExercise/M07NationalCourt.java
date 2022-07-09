package midExamExercise;
//https://judge.softuni.bg/Contests/Practice/Index/2031#0
import java.util.Arrays;
import java.util.Scanner;


public class M07NationalCourt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] efficiency = new int[3];
        for (int i = 0; i < efficiency.length; i++) {
            efficiency[i] = Integer.parseInt(scanner.nextLine());
        }

        int performance = Arrays.stream(efficiency).sum();
        int numPeople = Integer.parseInt(scanner.nextLine());
        int numWorkhours= (int) Math.ceil(1.0*numPeople/performance);
        int numBreaks = (numWorkhours-1)/3;
        System.out.printf("Time needed: %dh.", numWorkhours+numBreaks);
    }
}

