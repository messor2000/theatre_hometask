package visitor.comparators;

import visitor.Listener;

import java.util.Comparator;

public class SexComparator implements Comparator<Listener> {
    @Override
    public int compare(Listener o1, Listener o2) {
        return CharSequence.compare(o1.getSex(), o2.getSex());
    }
}


