package midExamExercise;
//https://judge.softuni.bg/Contests/Practice/Index/376#1

import java.util.*;
import java.util.stream.Collectors;

public class M20SoftUniKaraoke {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> participantNames = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());
        List<String> songs = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());

        List<Participant> participants = new ArrayList<>();
        String input = scanner.nextLine();
        while (!input.equals("dawn")) {
            String[] data = input.split(", ");
            String currentParticipant = data[0];
            String currentSong = data[1];
            String currentAward = data[2];

            if (participants
                    .stream()
                    .noneMatch(e -> e.getName().equals(currentParticipant))
                    && participantNames.contains(currentParticipant)
                    && songs.contains(currentSong)) {
                participants.add(new Participant(currentParticipant, currentAward));
            } else if (participants
                    .stream()
                    .anyMatch(e -> e.getName().equals(currentParticipant))
                    && participantNames.contains(currentParticipant)
                    && songs.contains(currentSong)) {
                participants
                        .stream()
                        .filter(e -> e.getName().equals(currentParticipant))
                        .collect(Collectors.toList())
                        .get(0)
                        .addAward(currentAward);
            }
            input = scanner.nextLine();
        }
        if (participants.isEmpty()) {
            System.out.println("No awards");
        } else {
            participants.sort(Comparator.comparing(Participant::getAwardsCount)
                    .reversed()
                    .thenComparing(Participant::getName));
            for (Participant participant : participants) {
                System.out.print(participant.name + ": " + participant.getAwardsCount() + " awards\n");
                participant.printSortedAwards();
            }
        }
    }

    public static class Participant {
        private String name;
        private List<String> awards = new ArrayList<>();

        public Participant(String name, String award) {
            this.name = name;
            addAward(award);
        }

        public void addAward(String award) {
            if (!awards.contains(award)) {
                awards.add(award);
            }
        }

        public String getName() {
            return name;
        }

        public int getAwardsCount() {
            return awards.size();
        }

        public void printSortedAwards() {

            Collections.sort(awards);
            awards.forEach(e -> System.out.println("--" + e));
        }
    }
}
