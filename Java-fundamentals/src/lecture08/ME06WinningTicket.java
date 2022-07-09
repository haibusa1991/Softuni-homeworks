package lecture08;

import java.util.Scanner;

public class ME06WinningTicket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tickets = scanner.nextLine().replaceAll(" ", "").split(",");
        for (int i = 0; i < tickets.length; i++) {
            tickets[i] = tickets[i].trim();
        }

        for (String ticket : tickets) {
            if (ticket.length() != 20) {
                System.out.println("invalid ticket");
                continue;
            }

            if (!ticket.contains("@")
                    && !ticket.contains("#")
                    && !ticket.contains("$")
                    && !ticket.contains("^")) {
                System.out.printf("ticket \"%s\" - no match\n", ticket);
                continue;
            }

            String[] leftHalf = checkHalfTicket(ticket.substring(0, 10));
            String[] rightHalf = checkHalfTicket(ticket.substring(10));

            if (leftHalf[0].equals("-1")
            || !leftHalf[1].equals(rightHalf[1])) {
                System.out.printf("ticket \"%s\" - no match\n", ticket);
                continue;
            }

            if (leftHalf[1].equals(rightHalf[1])) {
                System.out.printf("ticket \"%s\" - %s%s", ticket, Math.min(Integer.parseInt(leftHalf[0]), Integer.parseInt(rightHalf[0])), leftHalf[1]);
                if (leftHalf[0].equals(rightHalf[0]) && leftHalf[0].equals("10")) {
                    System.out.print(" Jackpot!\n");
                } else {
                    System.out.print("\n");
                }
            }
        }
    }


    private static String[] checkHalfTicket(String ticket) {
        String[] result = new String[2];
        int numAts = 0;
        int numHashes = 0;
        int numDollarSigns = 0;
        int numCarets = 0;

        for (int i = 1; i < ticket.length(); i++) {
            char currentChar = ticket.charAt(i);
            if (currentChar == '@') {
                if (ticket.charAt(i - 1) == '@') {
                    if (i == 1) {
                        numAts++;
                    }
                    numAts++;
                } else {
                    numAts = 1;
                }
            }

            if (currentChar == '#') {
                if (ticket.charAt(i - 1) == '#') {
                    if (i == 1) {
                        numHashes++;
                    }
                    numHashes++;
                } else {
                    numHashes = 1;
                }
            }
            if (currentChar == '$') {
                if (ticket.charAt(i - 1) == '$') {
                    if (i == 1) {
                        numDollarSigns++;
                    }
                    numDollarSigns++;
                } else {
                    numDollarSigns = 1;
                }
            }
            if (currentChar == '^') {
                if (ticket.charAt(i - 1) == '^') {
                    if (i == 1) {
                        numCarets++;
                    }
                    numCarets++;
                } else {
                    numCarets = 1;
                }
            }
        }

        if (numAts >= 6) {
            result[0] = "" + numAts;
            result[1] = "@";
        } else if (numHashes >= 6) {
            result[0] = "" + numHashes;
            result[1] = "#";
        } else if (numDollarSigns >= 6) {
            result[0] = "" + numDollarSigns;
            result[1] = "$";
        } else if (numCarets >= 6) {
            result[0] = "" + numCarets;
            result[1] = "^";
        } else {
            result[0] = "-1";
            result[1] = "X";
        }
        return result;
    }
}