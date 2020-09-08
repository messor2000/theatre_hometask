import theater.CashBox;
import theater.Competition;
import theater.Ticket;
import visitor.Listener;
import visitor.comparators.RespectComparator;
import visitor.comparators.SexComparator;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<Listener> listeners = new HashSet<>();
        listeners.add(new Listener.Builder()
                .gentleman(3));
        listeners.add(new Listener.Builder()
                .gentleman(4));
        listeners.add(new Listener.Builder()
                .lady(3));
        listeners.add(new Listener.Builder()
                .gentleman(1));
        listeners.add(new Listener.Builder()
                .gentleman(0));
        listeners.add(new Listener.Builder()
                .lady(4));
        listeners.add(new Listener.Builder()
                .lady(2));
        listeners.add(new Listener.Builder()
                .lady(6));
        listeners.add(new Listener.Builder()
                .lady(8));
        System.out.println("People in the queue");
        System.out.println(listeners.toString());

        System.out.println("--------");

        Comparator<Listener> comparator = new SexComparator()
                .thenComparing(new RespectComparator()).reversed();

        TreeSet<Listener> queue = new TreeSet<>(comparator);
        queue.addAll(listeners);

        System.out.println("People get in queue");
        for (Listener l: queue) {
            System.out.println(l);
        }

        System.out.println("--------");

        CashBox box = new CashBox();
        Map<Ticket, Listener> list = box.getListTicketsOwner(queue);


        System.out.println("List of ticket holders");
        for (Map.Entry<Ticket, Listener> entry : list.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

        System.out.println("--------");

        Competition competition = new Competition();
        competition.determineTheWinner(list);

        System.out.println("--------");

        System.out.println("List of ticket holders that have 2 or more tickets \n" +
                "and take 50% sale for the next buy");
        Set<Listener> set = box.getListOfTwoOrMoreTickets(list);
        for (Listener l: set) {
            System.out.println(l);
        }
    }
}
