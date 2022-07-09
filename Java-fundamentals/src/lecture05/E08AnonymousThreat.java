package lecture05;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E08AnonymousThreat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> input = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        String command = scanner.nextLine();
        while (!command.equals("3:1")) {
            String[] commandArr = command.split(" ");
            if (command.contains("merge")) {
                int startIndex = Integer.parseInt(commandArr[1]);
                if (startIndex < 0) {
                    startIndex = 0;
                }
                int endIndex = Integer.parseInt(commandArr[2]);
                int numMerges = endIndex - startIndex;
                for (int i = 0; i < numMerges; i++) {
                    if (startIndex + 1 >= input.size()) {
                        continue;
                    }
                    input.set(startIndex, input.get(startIndex) + input.get(startIndex + 1));
                    input.remove(startIndex + 1);
                }
            } else if (command.contains("divide")) {
                int index = Integer.parseInt(commandArr[1]);
                int numParts = Integer.parseInt(commandArr[2]);
                String element = input.get(index);
                int smallPartsLength = element.length() / numParts;

                String currentPart = "";
                int numAddedParts = 0;
                for (int i = 0; i < element.length(); i++) {
                    currentPart += element.charAt(i);
                    if (currentPart.length() == smallPartsLength && numAddedParts < numParts - 1) {
                        input.add(index + numAddedParts, currentPart);
                        numAddedParts++;
                        currentPart = "";
                    }
                }
                input.add(index + numAddedParts, currentPart);
                input.remove(element);
            }

            command = scanner.nextLine();
        }
        System.out.println(input.toString().replaceAll("[\\[\\],]", ""));
    }
}
