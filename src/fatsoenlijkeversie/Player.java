package fatsoenlijkeversie;

/**
 * Created by Rogier on 24-11-15
 */
public abstract class Player {

    public abstract int determineMove(Nonogram nonogram);

    public void makeMove(Nonogram nonogram) {
        int move = this.determineMove(nonogram);
        nonogram.move(move);
    }
}
