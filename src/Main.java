import theater.CashBox;
import theater.Ticket;
import visitor.Listener;
import visitor.comparators.BroochComparator;
import visitor.comparators.MustacheComparator;
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
                .gentleman(1));
        listeners.add(new Listener.Builder()
                .lady(4));
        listeners.add(new Listener.Builder()
                .lady(2));
        System.out.println("People in the queue");
        System.out.println(listeners.toString());

        System.out.println("--------");

        Comparator<Listener> comparator = new SexComparator()
                .thenComparing(new BroochComparator())
                .thenComparing(new MustacheComparator()).reversed();
        TreeSet<Listener> queue = new TreeSet<>(comparator);
        queue.addAll(listeners);

        System.out.println("People get in queue");
        for (Listener l: queue) {
            System.out.println(l);
        }

        System.out.println("--------");

        CashBox box = new CashBox();
        Map<Ticket, Listener> list = box.getListTicketsOwner(queue);

        Ticket ticket = new Ticket();
        for (Map.Entry<Ticket, Listener> entry : list.entrySet()) {
            switch (entry.getValue().getSex()) {
                case LADY:
                    ticket.setPrise(true);
//                    System.out.println(entry.getValue().getBroochNumbers());
                case GENTLEMAN:
//                    System.out.println(entry.getValue().getMustacheLength());
            }
        }

        System.out.println("List of ticket holders");
        for (Map.Entry<Ticket, Listener> entry : list.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }


        System.out.println("--------");

        System.out.println("List of ticket holders that have 2 or more tickets \n" +
                "and take 50% sale for the next buy");
        Set<Listener> set = box.getListOfTwoOrMoreTickets(list);
        for (Listener l: set) {
            System.out.println(l);
        }
    }
}