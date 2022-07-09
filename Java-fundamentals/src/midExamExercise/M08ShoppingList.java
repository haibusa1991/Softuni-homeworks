package midExamExercise;
//https://judge.softuni.bg/Contests/Practice/Index/2031#1
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class M08ShoppingList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> shoppingList = Arrays.stream(scanner.nextLine().split("!")).collect(Collectors.toList());
        String input = scanner.nextLine();
        while (!input.equals("Go Shopping!")) {
            String[] data = input.split(" ");
            String item = data[1];
            switch (data[0]) {
                case "Urgent":
                    if (!shoppingList.contains(item)) {
                        shoppingList.add(0, item);
                    }
                    break;
                case "Unnecessary":
                    shoppingList.remove(item);
                    break;
                case "Correct":
                    if(shoppingList.contains(item)){
                        String newItem = data[2];
                        shoppingList.set(shoppingList.indexOf(item),newItem);
                    }
                    break;
                case "Rearrange":
                    if(shoppingList.contains(item)){
                        shoppingList.remove(item);
                        shoppingList.add(item);
                    }
                    break;
            }
            input=scanner.nextLine();
        }
        System.out.println(shoppingList.toString().replaceAll("[\\[\\]]",""));
    }
}
