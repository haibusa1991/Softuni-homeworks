package finalExamExcercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//https://judge.softuni.bg/Contests/Practice/Index/2518#1
public class FEE11DestinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String map = scanner.nextLine();
        List<String> places=new ArrayList<>();
        Matcher matcher = Pattern.compile("([=/])[A-Z][A-Za-z]{2,}\\1").matcher(map);
        while (matcher.find()){
            places.add(matcher.group().substring(1,matcher.group().length()-1));
        }
        int travelPoints = 0;
        System.out.println("Destinations: " + places.toString().replaceAll("[\\[\\]]",""));
        for(String place:places){
            travelPoints+=place.length();
        }
        System.out.println("Travel Points: " + travelPoints);
    }
}
