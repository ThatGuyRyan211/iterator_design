/*Author: Ryan Callahan */
package iterator;

/** Represents one task on the Scrum board. */
public class Ticket {
    private final String name;
    private final String teamMember;
    private final Difficulty difficulty;

    public Ticket(String name, String teamMember, Difficulty difficulty) {
        this.name = name;
        this.teamMember = teamMember;
        this.difficulty = difficulty;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "- " + difficulty.ASCII + name + " (Difficulty: "
                + formatDifficulty() + ") - " + teamMember + "\u001B[0m";
    }

    private String formatDifficulty() {
        String difficultyName = difficulty.name().toLowerCase();
        return Character.toUpperCase(difficultyName.charAt(0)) + difficultyName.substring(1);
    }
}
