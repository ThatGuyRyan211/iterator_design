/*Author: Ryan Callahan */
package iterator;

import java.util.Iterator;

/** Iterates through the used positions of a TaskList's ticket array. */
public class TaskListIterator implements Iterator<Ticket> {
    private final Ticket[] tickets;
    private int position;

    public TaskListIterator(Ticket[] tickets) {
        this.tickets = tickets;
        this.position = 0;
    }

    @Override
    public boolean hasNext() {
        return position < tickets.length && tickets[position] != null;
    }

    @Override
    public Ticket next() {
        return tickets[position++];
    }
}
