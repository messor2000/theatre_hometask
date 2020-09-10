package theater;

import visitor.Listener;

import java.util.*;

public class Competition {
    public void determineTheWinner(Map<Ticket, Listener> map) {
        for (Map.Entry<Ticket, Listener> entry : map.entrySet()) {
            ArrayList<Listener> list = new ArrayList<>();
            list.add(entry.getValue());

            Ticket minByRespect = list
                    .stream()
                    .min(Comparator.comparing(Listener::getRespect))
                    .orElseThrow(NoSuchElementException::new);
            for (Listener l: list) {
                if (l == minByRespect) {
                    l.setPrise(true);
                    return;
                }
            }
        }
    }


}
