package s00_case_study_furama_resot.models;

import java.util.Deque;
import java.util.LinkedList;

public class Cinema4D {
    final static int CINEMA_STICKER = 15;
    private static Deque<String> dequeCinema = new LinkedList<>();
    private static int ticketBox = CINEMA_STICKER;

    public Cinema4D() {
    }

    public int getTicketBox() {
        return ticketBox;
    }

    public static void byTicker(String customer, int numberSticker) {
        if (ticketBox > numberSticker) {
            dequeCinema.add(customer);
            System.out.println("Successful ticket purchase.");
            ticketBox -= numberSticker;
        } else if (ticketBox == numberSticker) {
            dequeCinema.add(customer);
            ticketBox = 0;
            System.out.println("Successful ticket purchase.");
            while (!dequeCinema.isEmpty()) {
                System.out.println(dequeCinema.poll());
            }
        } else {
            System.out.println("Sorry, the ticket is over. Please come back tomorrow. Thank you");
        }
    }

}
