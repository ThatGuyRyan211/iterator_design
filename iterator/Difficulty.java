/*Author: Ryan Callahan */

package iterator;

/** The difficulty of a Scrum ticket and its terminal display color. */
public enum Difficulty {
    HARD("\u001B[31m"),
    MEDIUM("\u001B[32m"),
    EASY("\u001B[33m");

    public final String ASCII;

    Difficulty(String ascii) {
        this.ASCII = ascii;
    }
}
