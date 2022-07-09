package lecture01WorkingWithAbstraction.E02CardRank;

public class Main {
    public static void main(String[] args) {
        System.out.println("Card Ranks:");
        for(Rank r: Rank.values()){
            System.out.printf("Ordinal value: %d; Name value: %s%n",r.ordinal(),r.name());
        }
    }
}
