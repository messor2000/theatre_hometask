package theater;

import visitor.Listener;

import java.util.*;

public class CashBox {

    public Map<Ticket, Listener> getListTicketsOwner(TreeSet<Listener> listeners) {
        Map<Ticket, Listener> tickets = new HashMap<>();
        for (Listener listener : listeners) {
            int randomTicketCount = (int) (1 + Math.random() * 3);
            for (int i = 0; i < randomTicketCount; i++) {
                int numberCounter = (int) (1 + Math.random() * 30);
                int placeCounter = (int) (1 + Math.random() * 30);
                int rowCounter = (int) (1 + Math.random() * 30 / 10);

                Ticket ticket = new Ticket.Builder().ticket(numberCounter, placeCounter, rowCounter);
                tickets.put(ticket, listener);
            }
        }
        return tickets;
    }

    public Set<Listener> getListOfTwoOrMoreTickets(Map<Ticket, Listener> map) {
        Set<Listener> set = new HashSet<>();

        HashSet<Listener> set2 = new HashSet<>(map.values());
        for (Listener l : set2) {
            int i = Collections.frequency(map.values(), l);
            if (i > 1) {
                set.add(l);
            }
        }
        return set;
    }
}
