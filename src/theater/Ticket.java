package theater;

import java.util.Objects;

public class Ticket {
    private int ticketNumber;
    private int place;
    private int row;
    private boolean prise;

    public static class Builder {
        private final Ticket ticket;

        public Builder() {
            ticket = new Ticket();
        }

        public Ticket ticket(int ticketNumber, int place, int row) {
            ticket.ticketNumber = ticketNumber;
            ticket.place = place;
            ticket.row = row;
            return ticket;
        }
    }

    public void setPrise(boolean prise) {
        this.prise = prise;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketNumber=" + ticketNumber +
                ", place=" + place +
                ", row=" + row +
                ", prise=" + prise +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return ticketNumber == ticket.ticketNumber &&
                place == ticket.place &&
                row == ticket.row;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketNumber, place, row);
    }
}
