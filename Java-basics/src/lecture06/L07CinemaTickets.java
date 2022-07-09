package lecture06;

import java.util.Scanner;

public class L07CinemaTickets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int standardTickets = 0;
        int studentTickets = 0;
        int kidTickets = 0;
        int totalTickets = 0;

        while (true) {
            String movieName = scanner.nextLine();

            if (movieName.equalsIgnoreCase("finish")) {
                break;
            }

            int numSeats = Integer.parseInt(scanner.nextLine());
            int occupiedSeats = 0;

            while (occupiedSeats < numSeats) {
                String ticketType = scanner.nextLine();

                if (ticketType.equalsIgnoreCase("end")) {
                    break;
                }

                if (ticketType.equalsIgnoreCase("standard")) {
                    standardTickets++;
                } else if (ticketType.equalsIgnoreCase("student")) {
                    studentTickets++;
                } else if (ticketType.equalsIgnoreCase("kid")) {
                    kidTickets++;
                }
                occupiedSeats++;
                totalTickets++;
            }
            System.out.printf("%s - %.2f%% full.\n", movieName, 1.0 * occupiedSeats / numSeats * 100);
        }
        System.out.printf("Total tickets: %d\n" +
                        "%.2f%% student tickets.\n" +
                        "%.2f%% standard tickets.\n" +
                        "%.2f%% kids tickets.",
                totalTickets,
                1.0 * studentTickets / totalTickets * 100,
                1.0 * standardTickets / totalTickets * 100,
                1.0 * kidTickets / totalTickets * 100);
    }
}