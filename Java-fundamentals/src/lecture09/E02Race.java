package lecture09;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class E02Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> racersNames = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        Map<String, Integer> racers = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("end of race")) {
            String[] result = getInfo(input);
            String name = result[0];
            int distance = Integer.parseInt(result[1]);

            if (racersNames.contains(name)) {
                if (racers.containsKey(name)) {
                    racers.put(name, racers.get(name) + distance);
                }
                racers.putIfAbsent(name, distance);
            }
            input=scanner.nextLine();
        }
        List<String> podiumRacers = racers.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println("1st place: " + podiumRacers.get(0));
        System.out.println("2nd place: " + podiumRacers.get(1));
        System.out.println("3rd place: " + podiumRacers.get(2));
    }

    private static String[] getInfo(String input) {
        String[] result = new String[2];
        String regexName = "[A-Za-z]+";
        Matcher matcherName = Pattern.compile(regexName).matcher(input);
        StringBuilder name = new StringBuilder();
        while (matcherName.find()) {
            name.append(matcherName.group());
        }

        String regexDistance = "[0-9]";
        Matcher matcherDistance = Pattern.compile(regexDistance).matcher(input);
        int distance = 0;
        while (matcherDistance.find()) {
            distance += Integer.parseInt(matcherDistance.group());
        }
        result[0] = name.toString();
        result[1] = "" + distance;
        return result;
    }
}
