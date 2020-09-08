package theater;

import visitor.Listener;

import java.util.*;

public class Competition {
    public void determineTheWinner(Map<Ticket, Listener> map) {
        Object personWithMinRespect = map.values().stream()
                .min(Comparator.comparing(Listener::getRespect))
                .orElseThrow(NullPointerException::new);
        System.out.println(personWithMinRespect);

        List<Ticket> winningTickets = new ArrayList<>();

        for (Ticket key : map.keySet()) {
            if (map.get(key).equals(personWithMinRespect)) {
                key.setPrise(true);
                winningTickets.add(key);
            }
        }

        winningTickets.forEach(System.out::println);
    }
}
