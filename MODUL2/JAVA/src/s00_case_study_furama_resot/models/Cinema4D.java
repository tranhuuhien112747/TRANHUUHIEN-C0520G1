package s00_case_study_furama_resot.models;

import java.util.LinkedList;
import java.util.Queue;

public class Cinema4D {
    final static int CINEMA_STICKER = 15;
    private static Queue<Customer> dequeCinema = new LinkedList<>();
    private static int ticketBox = CINEMA_STICKER;

    public static int getTicketBox() {
        return ticketBox;
    }

    public static void byTicker(Customer customer, int numberSticker) {
        if (ticketBox > numberSticker) {
            dequeCinema.add(customer);
            ticketBox -= numberSticker;
            System.out.println("Successful ticket purchase.");
        } else if (ticketBox == numberSticker) {
            dequeCinema.add(customer);
            ticketBox = 0;
            System.out.println("Successful ticket purchase.");
            System.out.println("  List Customer Buy Ticket Cinema 4D");
            System.out.printf("%-25s%-20s", "Name Customer", "Number Phone");
            System.out.println();
            while (!dequeCinema.isEmpty()) {
                Customer customer1 = dequeCinema.poll();
                System.out.printf("%-25s%-20s", customer1.getNameCustomer(), customer1.getPhoneNumber());
                System.out.println();
            }
            System.out.println();
        }
    }

}
