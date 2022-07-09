package lecture09;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ME01WinningTicket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tickets = Arrays.stream(scanner.nextLine().split(",")).map(String::trim).toArray(String[]::new);
        for (String ticket : tickets) {
            validate(ticket);
        }
    }

    private static void validate(String ticket) {
        if (ticket.length() != 20) {
            System.out.println("invalid ticket");
            return;
        }
        String formattedTicket = ticket.substring(0, 10) + " " + ticket.substring(10, 20);
        Matcher matcher = Pattern.compile(".*?(?<symbolsLeft>@{6,10}|#{6,10}|\\${6,10}|\\^{6,10}).*?(?<symbolsRight>@{6,10}|#{6,10}|\\${6,10}|\\^{6,10}).*").matcher(formattedTicket);
        String leftMatch = "";
        String rightMatch = "";
        if (matcher.find()) {
            leftMatch = matcher.group("symbolsLeft");
            rightMatch = matcher.group("symbolsRight");
        }

        if (leftMatch.length() == 0
                || rightMatch.length() == 0
                || leftMatch.charAt(0) != rightMatch.charAt(0)) {
            System.out.println("ticket \"" + ticket + "\" - no match");
            return;
        }

        if (leftMatch.length() == rightMatch.length() && leftMatch.length() == 10) {
            System.out.println("ticket \"" + ticket + "\" - " + leftMatch.length() + leftMatch.charAt(0) + " Jackpot!");
        } else {
            System.out.println("ticket \"" + ticket + "\" - " + Math.min(leftMatch.length(),rightMatch.length()) + leftMatch.charAt(0));
        }

    }
}
