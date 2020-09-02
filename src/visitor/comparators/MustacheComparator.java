package visitor.comparators;

import visitor.Listener;

import java.util.Comparator;

public class MustacheComparator implements Comparator<Listener> {

    @Override
    public int compare(Listener o1, Listener o2) {
        return Integer.compare(o1.getMustacheLength(), o2.getMustacheLength());
    }
}
