package iterator;

public class ProjectDriver {
    public void run() {
        clear();
        SCRUMBoard board = new SCRUMBoard("Recipe Application");
        board.addTicket("Create Git Repo", "Katie", Difficulty.EASY);
        board.addTicket("Create Recipe Stub", "Jim", Difficulty.EASY);
        board.addTicket("Create all JSON Files", "Katie", Difficulty.HARD);
        board.addTicket("Create User Class", "Sam", Difficulty.MEDIUM);
        board.addTicket("Create Author Class", "Sam", Difficulty.MEDIUM);
        board.addTicket("Create Recipe Class", "Jim", Difficulty.HARD);

        board.startTicket("Create Git Repo");
        board.finishTicket("Create Git Repo");
        board.startTicket("Create all JSON Files");
        board.startTicket("Create Recipe Stub");

        System.out.println(board);
    }

    public void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) {
        new ProjectDriver().run();
    }
}
