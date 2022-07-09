package L04StreamsFilesAndDirectories;

import java.io.*;
import java.util.Set;

public class E04CountCharacterTypes {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("D:\\Repos\\SoftUni\\Java-advanced\\src\\L04StreamsFilesAndDirectories\\ExerciseFiles\\input.txt");
        byte[] symbols = fis.readAllBytes();

        int countVowels = 0;
        int countConsonants = 0;
        int countPunctuation = 0;
        Set<Character> vowels = Set.of('a', 'o', 'u', 'e', 'i');
        Set<Character> punctuation = Set.of(',', '.', '!', '?');
        for (byte c : symbols) {
            if (vowels.contains((char) c)) {
                countVowels++;
            } else if (punctuation.contains((char) c)) {
                countPunctuation++;
            } else if ((c!=13 && c!=10 && c!=32)) {
                countConsonants++;
            }
        }
        System.out.println("Vowels: " + countVowels);
        System.out.println("Consonants: " + countConsonants);
        System.out.println("Punctuation: " + countPunctuation);
    }
}
