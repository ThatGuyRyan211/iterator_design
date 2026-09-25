/*Author: Ryan Callahan */
package iterator;

/** A named collection of tickets, such as ToDo, Doing, or Done. */
public class TaskList {
    private Ticket[] tickets;
    private int count;
    private final String name;

    public TaskList(String name) {
        this.name = name;
        this.tickets = new Ticket[10];
        this.count = 0;
    }

    public void addTicket(String name, String teamMember, Difficulty difficulty) {
        addTicket(new Ticket(name, teamMember, difficulty));
    }

    public void addTicket(Ticket ticket) {
        if (count == tickets.length) {
            Ticket[] largerTickets = new Ticket[tickets.length * 2];
            System.arraycopy(tickets, 0, largerTickets, 0, tickets.length);
            tickets = largerTickets;
        }
        tickets[count++] = ticket;
    }

    public Ticket getTicket(String name) {
        for (int i = 0; i < count; i++) {
            if (tickets[i].getName().equalsIgnoreCase(name)) {
                return tickets[i];
            }
        }
        return null;
    }

    /** Removes and returns a ticket with the given name, or null if absent. */
    public Ticket removeTicket(String name) {
        for (int i = 0; i < count; i++) {
            if (tickets[i].getName().equalsIgnoreCase(name)) {
                Ticket ticket = tickets[i];
                for (int j = i; j < count - 1; j++) {
                    tickets[j] = tickets[j + 1];
                }
                tickets[--count] = null;
                return ticket;
            }
        }
        return null;
    }

    public TaskListIterator createIterator() {
        Ticket[] activeTickets = new Ticket[count];
        System.arraycopy(tickets, 0, activeTickets, 0, count);
        return new TaskListIterator(activeTickets);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder(name + ":\n");
        TaskListIterator iterator = createIterator();
        while (iterator.hasNext()) {
            output.append(iterator.next()).append('\n');
        }
        return output.toString();
    }
}
