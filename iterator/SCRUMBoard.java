/*Author: Ryan Callahan */
package iterator;

/** Coordinates ticket movement among the three columns of a Scrum board. */
public class SCRUMBoard {
    private final String projectName;
    private final TaskList todo;
    private final TaskList doing;
    private final TaskList done;

    public SCRUMBoard(String projectName) {
        this.projectName = projectName;
        this.todo = new TaskList("ToDo");
        this.doing = new TaskList("Doing");
        this.done = new TaskList("Done");
    }

    public void addTicket(String name, String teamMember, Difficulty difficulty) {
        todo.addTicket(name, teamMember, difficulty);
    }

    public boolean startTicket(String name) {
        Ticket ticket = todo.removeTicket(name);
        if (ticket == null) {
            return false;
        }
        doing.addTicket(ticket);
        return true;
    }

    public boolean finishTicket(String name) {
        Ticket ticket = doing.removeTicket(name);
        if (ticket == null) {
            return false;
        }
        done.addTicket(ticket);
        return true;
    }

    @Override
    public String toString() {
        return "***** " + projectName + " *****\n" + todo + "\n" + doing + "\n" + done;
    }
}
